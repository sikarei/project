package Admin;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 * A simple demonstration application showing how to create a bar chart overlaid
 * with a line chart.
 */

public class Chart {   
	static Timer texit;
	static TimerTask ttask;
       // Run As > Java Application ���� �����ϸ� �ٷ� Ȯ���� �� ����.
	static int cur;
	StockDB sd;
	DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1
	public JFreeChart getChart() {
        // ������ ����
		sd = new StockDB();
        

    	texit = new Timer();
		ttask = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
		        ChartAdd();        // ������ �Է� �ݺ� ( ��, ����, ī�װ� )     
			}
		};
		texit.schedule(ttask, 4500,2000);
		ChartAdd(); // ������ �Է� ( ��, ����, ī�װ� )     
        // ������ ���� �� ����
        // ������ ����
        final BarRenderer renderer = new BarRenderer();

        // ���� �ɼ� ����
        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        final ItemLabelPosition p_center = new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER
            );
        final ItemLabelPosition p_below = new ItemLabelPosition(
                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT
                     );
        Font f = new Font("Gulim", Font.BOLD, 14);
        Font axisF = new Font("Gulim", Font.PLAIN, 10);

        // ������ ����
        // �׷��� 1
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(p_center);
        renderer.setBaseItemLabelFont(f);

        renderer.setSeriesPaint(0, new Color(0,162,255));

        // plot ����
        final CategoryPlot plot = new CategoryPlot();

        // plot �� ������ ����

        plot.setDataset(dataset1);
        plot.setRenderer(renderer);

        // plot �⺻ ����
        plot.setOrientation(PlotOrientation.VERTICAL);             // �׷��� ǥ�� ����
        plot.setRangeGridlinesVisible(true);                       // X�� ���̵� ���� ǥ�ÿ���
        plot.setDomainGridlinesVisible(true);                      // Y�� ���̵� ���� ǥ�ÿ���

        // ������ ���� ���� : dataset ��� ������� ������ ( ��, ���� ����Ѱ� �Ʒ��� �� )
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        // X�� ����
        plot.setDomainAxis(new CategoryAxis());              // X�� ���� ����
        plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // ī�װ� �� ��ġ ����

        // Y�� ����
        plot.setRangeAxis(new NumberAxis());                 // Y�� ���� ����
        plot.getRangeAxis().setTickLabelFont(axisF);  // Y�� ���ݶ� ��Ʈ ����

        // ���õ� plot�� �������� chart ����

        final JFreeChart chart = new JFreeChart(plot);
        return chart;
    }
	void ChartAdd() {
		dataset1.addValue(sd.SelectCur("�Ұ��"), "����(���� : %)", "�Ұ��");
        dataset1.addValue(sd.SelectCur("�������"),"����(���� : %)", "�������");
        dataset1.addValue(sd.SelectCur("ġ�����"), "����(���� : %)", "ġ�����");
        dataset1.addValue(sd.SelectCur("ġŲ����"), "����(���� : %)", "ġŲ����");
        dataset1.addValue(sd.SelectCur("ġ�ƽ"), "����(���� : %)", "ġ�ƽ");
        dataset1.addValue(sd.SelectCur("ġŲ��"), "����(���� : %)", "ġŲ��");
        dataset1.addValue(sd.SelectCur("������"), "����(���� : %)", "������");
        dataset1.addValue(sd.SelectCur("����Ƣ��"), "����(���� : %)", "����Ƣ��");
        dataset1.addValue(sd.SelectCur("�ݶ�"), "����(���� : %)", "�ݶ�");
        dataset1.addValue(sd.SelectCur("���̴�"), "����(���� : %)", "���̴�");
        dataset1.addValue(sd.SelectCur("ȯŸ"), "����(���� : %)", "ȯŸ");
        dataset1.addValue(sd.SelectCur("Ŀ��"), "����(���� : %)", "Ŀ��");
        dataset1.addValue(sd.SelectCur("������"), "����(���� : %)", "������");
        dataset1.addValue(sd.SelectCur("ġ��"), "����(���� : %)", "ġ��");
        dataset1.addValue(sd.SelectCur("��"), "����(���� : %)", "��");
        dataset1.addValue(sd.SelectCur("���"), "����(���� : %)", "���");
	}

    
}
