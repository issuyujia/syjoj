package com.syj.syjojcodesandbox.utils;

/**
 * @author syj
 * @date 2024/8/3 23:33
 */

import cn.hutool.core.util.StrUtil;
import com.syj.syjojcodesandbox.model.ExecuteMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StopWatch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 程序执行进程工具类
 */
public class ProcessUtils {
    /**
     * 执行进程并获取信息
     *
     * @param runProcess
     * @return
     * @Param opName
     */
    public static ExecuteMessage runProcessAndGetMessage(Process runProcess, String opName) {
        ExecuteMessage executeMessage = new ExecuteMessage();
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            //等待程序执行，获取错误码
            int execValue = runProcess.waitFor();
            executeMessage.setExitValue(execValue);
            //正常退出
            if (execValue == 0) {
                System.out.println(opName + "成功");
                StringBuilder compileOutStreamBuilder = new StringBuilder();
                //分配获取进程的输出
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                List<String> outputStrList = new ArrayList<>();
                //逐行读取
                String compileOutPutLine;
                while ((compileOutPutLine = bufferedReader.readLine()) != null) {
                    outputStrList.add(compileOutPutLine);
                }
                executeMessage.setMessage(StringUtils.join(outputStrList, "\n"));
            } else {
                //异常退出
                System.out.println(opName + "失败，错误码：" + execValue);
                //分配获取进程的输出
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                List<String> outputStrList = new ArrayList<>();
                //逐行读取
                String compileOutPutLine;
                while ((compileOutPutLine = bufferedReader.readLine()) != null) {
                    outputStrList.add(compileOutPutLine);
                }
                executeMessage.setMessage(StringUtils.join(outputStrList, "\n"));

                //分批获取错误输出
                BufferedReader errorBufferReader = new BufferedReader(new InputStreamReader(runProcess.getErrorStream()));
                //逐行读取
                List<String> errorOutputStrList = new ArrayList<>();
                //逐行读取
                String errorCompileOutPutLine;
                while ((errorCompileOutPutLine = errorBufferReader.readLine()) != null) {
                    errorOutputStrList.add(errorCompileOutPutLine);
                }
                executeMessage.setErrorMessage(StringUtils.join(errorOutputStrList, "\n"));
            }
            stopWatch.stop();
            executeMessage.setTime(stopWatch.getLastTaskTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return executeMessage;
    }

    /**
     * 执行交互式进程并获取信息
     *
     * @param runProcess
     * @param opName
     * @return
     */
    public static ExecuteMessage runInteractProcessAndGetMessage(Process runProcess, String opName, String args) {
        ExecuteMessage executeMessage = new ExecuteMessage();
        try {
            //从控制台获取缓存流
            OutputStream outputStream = runProcess.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            String[] s = args.split(" ");
            String join = StrUtil.join("\n", s) + "\n";
            outputStreamWriter.write(join);
            //相当于按了回车，执行输入的发送
            outputStreamWriter.flush();
            StringBuilder compileOutStreamBuilder = new StringBuilder();
            //分配获取进程的正常输出
            InputStream inputStream = runProcess.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
            //逐行读取
            String compileOutPutLine;
            while ((compileOutPutLine = bufferedReader.readLine()) != null) {
                compileOutStreamBuilder.append(compileOutPutLine);
            }
            executeMessage.setMessage(compileOutStreamBuilder.toString());
            //进行资源的回收
            outputStream.close();
            outputStreamWriter.close();
            inputStream.close();
            runProcess.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return executeMessage;
    }
}
