package bsu.rfe.java.group6.lab2.Serba.var6B;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
//import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
@SuppressWarnings ("serial")
public class main_frame extends JFrame{
	private static final int WIDTH = 350;
	private static final int HEIGHT = 350;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldZ;
	private JTextField textFieldResult;
	private ButtonGroup radioButtons = new ButtonGroup();
	private ButtonGroup radioButton_s = new ButtonGroup();

	private Box hboxFormulaType = Box.createHorizontalBox();
	private int formulaId = 1;
	private int memID;



	public Double calculate1(Double x, Double y, Double z) {
		return Math.round(((Math.pow((Math.log((1+z)*(1+z))+Math.cos(3.14*y*y*y)),1/4))/Math.pow(Math.cos(Math.pow(2.73,x))+Math.pow(1/x,1/2)+Math.pow(2.73,Math.pow(x,2)),Math.sin(x)))*100.0)/100.0;
	}
	public Double calculate2(Double x, Double y, Double z) {
		return Math.round((Math.tan(x*x)+Math.pow(y,1/2))/(z*Math.log10(x+y))*100.0)/100.0;
	}

	private void addRadioButton(String buttonName, final int formulaId) {
		JRadioButton button = new JRadioButton(buttonName);
		button.addActionListener(new ActionListener() {
			//private JComponent imagePane;

			public void actionPerformed(ActionEvent ev) {
				main_frame.this.formulaId = formulaId;
				//imagePane.updateUI();
			}
		});
		radioButtons.add(button);
		hboxFormulaType.add(button);
	}
	private void addRadioButton_mem(String buttonName, final int memID) {
		JRadioButton button = new JRadioButton(buttonName);
		button.addActionListener(new ActionListener() {
			//private JComponent imagePane;

			public void actionPerformed(ActionEvent ev) {
				main_frame.this.memID = memID;
				//imagePane.updateUI();
			}
		});
		radioButton_s.add(button);
		hboxFormulaType.add(button);
	}
	public main_frame() {
		super("Вычисление формулы");
		setSize(WIDTH,HEIGHT);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setLocation((kit.getScreenSize().width - WIDTH)/2, 
				(kit.getScreenSize().height - HEIGHT)/2);
		hboxFormulaType.add(Box.createHorizontalGlue());
		addRadioButton("Формула 1", 1);
		addRadioButton("Формула 2", 2);
		radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
		addRadioButton_mem("переменная 1", 1);

		addRadioButton_mem("переменная 2", 2);				

		addRadioButton_mem("переменная 3", 3);
		radioButton_s.setSelected(radioButtons.getElements().nextElement().getModel(), true);


		hboxFormulaType.add(Box.createHorizontalGlue());
		hboxFormulaType.setBorder(
				BorderFactory.createLineBorder(Color.YELLOW));
		JLabel labelForX = new JLabel("X:");
		textFieldX = new JTextField("0", 10);
		textFieldX.setMaximumSize(textFieldX.getPreferredSize());
		JLabel labelForY = new JLabel("Y:");
		textFieldY = new JTextField("0", 10);
		textFieldY.setMaximumSize(textFieldY.getPreferredSize());
		JLabel labelForZ = new JLabel("Z:");
		textFieldZ = new JTextField("0", 10);
		textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
		Box hboxVariables = Box.createHorizontalBox();
		hboxVariables.setBorder(
				BorderFactory.createLineBorder(Color.RED));
		hboxVariables.add(Box.createHorizontalGlue());
		hboxVariables.add(labelForX);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldX);
		hboxVariables.add(Box.createHorizontalStrut(100));
		hboxVariables.add(labelForY);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldY);
		hboxVariables.add(Box.createHorizontalGlue());
		hboxVariables.add(Box.createHorizontalStrut(100));
		hboxVariables.add(labelForZ);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldZ);
		hboxVariables.add(Box.createHorizontalGlue());
		JLabel labelForResult = new JLabel("Результат:");
		textFieldResult = new JTextField("0", 10);
		textFieldResult.setMaximumSize(
				textFieldResult.getPreferredSize());
		Box hboxResult = Box.createHorizontalBox();
		hboxResult.add(Box.createHorizontalGlue());
		hboxResult.add(labelForResult);
		hboxResult.add(Box.createHorizontalStrut(10));
		hboxResult.add(textFieldResult);
		hboxResult.add(Box.createHorizontalGlue());
		hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		JButton buttonCalc = new JButton("Вычислить");
		buttonCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					Double x = Double.parseDouble(textFieldX.getText());
					Double y = Double.parseDouble(textFieldY.getText());
					Double z = Double.parseDouble(textFieldZ.getText());

					Double result;
					

					if (formulaId==1)
					{
						result = calculate1(x, y,z);
					}
					else
						result = calculate2(x, y, z);
					textFieldResult.setText(result.toString());
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(main_frame.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", 
							JOptionPane.WARNING_MESSAGE);
				}
				/*Double x = Double.parseDouble(textFieldX.getText());
				Double y = Double.parseDouble(textFieldY.getText());
				Double z = Double.parseDouble(textFieldZ.getText());

				Double result;

				if (formulaId==1)
					result = calculate1(x, y,z);
				else
					result = calculate2(x, y, z);
				textFieldResult.setText(result.toString());*/
			}
		});
		
		JButton buttonReset = new JButton("Очистить поля");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				textFieldX.setText("0");
				textFieldY.setText("0");
				textFieldZ.setText("0");

				textFieldResult.setText("0");
			}
		});

		


		JButton mc = new JButton("MC");
		mc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				memID = 0;
				radioButton_s.clearSelection();
				}
		});

		
		
		//Double result = 0.0;
		JButton m_plus = new JButton("M+");
		m_plus.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent ev) {
				Double mem1 = 1.0;
				Double mem2 = 2.0;
				Double mem3 = 3.0;
				
				Double result = Double.parseDouble(textFieldResult.getText());
				 if(memID == 1) {
					 mem1+=result;
					
						textFieldResult.setText(mem1.toString());

					}
					else
						if(memID == 2) {
							mem2+=result;
							textFieldResult.setText(mem2.toString());

						}
						else
							if(memID == 3) {
								mem3+=result;
								textFieldResult.setText(mem3.toString());
							}
			}
			});
		Box hboxButtons = Box.createHorizontalBox();
		hboxButtons.add(Box.createHorizontalGlue());
		hboxButtons.add(mc);
		hboxButtons.add(Box.createHorizontalStrut(30));
		hboxButtons.add(m_plus);

		//Box hboxButtons = Box.createHorizontalBox();
		hboxButtons.add(Box.createHorizontalGlue());
		hboxButtons.add(buttonCalc);
		hboxButtons.add(Box.createHorizontalStrut(30));
		hboxButtons.add(buttonReset);
		hboxButtons.add(Box.createHorizontalGlue());
		hboxButtons.setBorder(
				BorderFactory.createLineBorder(Color.GREEN));
		Box contentBox = Box.createVerticalBox();
		contentBox.add(Box.createVerticalGlue());
		contentBox.add(hboxFormulaType);
		contentBox.add(hboxVariables);
		contentBox.add(hboxResult);
		contentBox.add(hboxButtons);
		contentBox.add(Box.createVerticalGlue());
		getContentPane().add(contentBox, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		main_frame frame = new main_frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
