module.exports = {
  presets: ["@vue/cli-plugin-babel/preset"],
  plugins: [
    // 添加这个插件来支持静态类字段
    "@babel/plugin-transform-class-static-block",
  ],
};
