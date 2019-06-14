/**
 * 
 */

$(document).ready(function() {
	initHistogram();
	initRadar();
})
function initHistogram(){
    var myChart = echarts.init(document.getElementById('bar'), 'macarons');
    // 指定图表的配置项和数据
    option = {
    	    title : {
    	        text: '课程作业分数统计',
    	        subtext: '虚构'
    	    },
    	    tooltip : {
    	        trigger: 'axis'
    	    },
    	    legend: {
    	        data:['分数']
    	    },
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            mark : {show: true},
    	            dataView : {show: true, readOnly: false},
    	            magicType : {show: true, type: ['line', 'bar']},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    calculable : true,
    	    xAxis : [
    	        {
    	            type : 'category',
    	            data : ['作业1','作业2','作业3','作业4','作业5','作业6','作业7','作业8','作业9','作业10','作业11','作业12']
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'分数',
    	            type:'bar',
    	            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 85.6, 92.2, 32.6, 20.0, 6.4, 3.3],
    	            markPoint : {
    	                data : [
    	                    {type : 'max', name: '最大值'},
    	                    {type : 'min', name: '最小值'}
    	                ]
    	            },
    	            markLine : {
    	                data : [
    	                    {type : 'average', name: '平均值'}
    	                ]
    	            }
    	        }
    	    ]
    	};
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function initRadar(){
	var myChart = echarts.init(document.getElementById('radar'), 'macarons');
    // 指定图表的配置项和数据

	option = {
	    title : {
	        text: '作业分数雷达图',
	        subtext: '纯属虚构'
	    },
	    tooltip : {
	        trigger: 'axis'
	    },
	    legend: {
	        orient : 'vertical',
	        x : 'right',
	        y : 'bottom',
	        data:['作业分数雷达图']
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: true, readOnly: false},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    polar : [
	       {
	           indicator : [
	               { text: '作业1', max: 6000},
	               { text: '作业2', max: 16000},
	               { text: '作业3', max: 30000},
	               { text: '作业4', max: 38000},
	               { text: '作业5', max: 52000},
	               { text: '作业6', max: 25000}
	            ]
	        }
	    ],
	    calculable : true,
	    series : [
	        {
	            name: '作业分数雷达图',
	            type: 'radar',
	            data : [
	                {
	                    value : [4300, 10000, 28000, 35000, 50000, 19000],
	                    name : '作业分数雷达图'
	                }
	            ]
	        }
	    ]
	};
	                    
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}