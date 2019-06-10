/**
 * 
 */
var editor = CodeMirror.fromTextArea(document.getElementById("CodeMirrorArea"), {
    mode: "text/x-java",
	lineNumbers: true,	//显示行号
	//theme: "blackboard",	//设置主题
	foldGutter: true,
	//gutters: ["CodeMirror-linenumbers", "CodeMirror-foldgutter"],
	matchBrackets: true,	//括号匹配
	smartIndent : true,  // 是否智能缩进
	indentUnit:4,
	autofocus: true
	//readOnly: true,        //只读
	
});