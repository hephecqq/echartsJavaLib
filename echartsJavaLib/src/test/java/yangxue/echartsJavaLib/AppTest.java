package yangxue.echartsJavaLib;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Line;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void test(){
		 //地址:http://echarts.baidu.com/doc/example/line5.html
	    Option option = new Option();
	    option.legend("高度(km)与气温(°C)变化关系");//设置echarts图例

	    option.toolbox()//设置echarts toolbox(工具栏)
	    	.show(true).//显示该工具栏
	    		feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar),
	    				Tool.restore, 
	    					Tool.saveAsImage);

	    option.calculable(true);//利用echarts重新计算能力
	    option.tooltip().//设置echarts tooltip（提示组件）
	    	trigger(Trigger.axis).//触发方式
	    		formatter("Temperature : <br/>{b}km : {c}°C");//格式化该输出样式

	    ValueAxis valueAxis = new ValueAxis();//设置值类型的Axis
	    valueAxis.axisLabel().formatter("{value} °C");
	    option.xAxis(valueAxis);

	    CategoryAxis categoryAxis = new CategoryAxis();//设置类目类型Axis
	    categoryAxis.axisLine().onZero(false);
	    categoryAxis.axisLabel().formatter("{value} km");
	    categoryAxis.boundaryGap(false);
	    categoryAxis.data(0, 10, 20, 30, 40, 50, 60, 70, 80);//为类目类型的Axis添加数据
	    option.yAxis(categoryAxis);

	    Line line = new Line();//折线图
	    line.smooth(true).name("高度(km)与气温(°C)变化关系").
	    	data(15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");//设置折线图数据及相关样式
	    option.series(line);
	   /* option.exportToHtml("line5.html");
	    option.view();*/
	    System.out.println(option);
	    System.out.println(JSON.toJSONString(option));//转化为json类型option,返回给客户端
	}
}
