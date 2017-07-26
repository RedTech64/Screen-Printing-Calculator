package Main;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Application extends JFrame {
	private static final long serialVersionUID = 1L;
	ImageIcon icon = new ImageIcon(Main.class.getClassLoader().getResource("icon.png"));
	
	double shirtPrice = 0;
	int quantity = 0;
	double markup = 0;
	double flash = 0;
	double art = 0;
	
	private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	private NumberFormat numberFormat = NumberFormat.getNumberInstance();
	private NumberFormat percentFormat = NumberFormat.getPercentInstance();
	
	JLabel lblTitle = new JLabel("Screen Printing Calculator");
	JLabel lblLocation1 = new JLabel("Location 1");
	JLabel lblLocation2 = new JLabel("Location 2");
	JLabel lblLocation3 = new JLabel("Location 3");
	SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(0.0, 0.0, 6.0, 1.0);
	SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(0.0, 0.0, 6.0, 1.0);
	SpinnerNumberModel spinnerModel3 = new SpinnerNumberModel(0.0, 0.0, 6.0, 1.0);
	JSpinner spinner1 = new JSpinner(spinnerModel1);
	JSpinner spinner2 = new JSpinner(spinnerModel2);
	JSpinner spinner3 = new JSpinner(spinnerModel3);
	JSeparator separator = new JSeparator();
	JLabel lblShirtCost = new JLabel("Shirt Cost");
	JLabel lblQuantity = new JLabel("Quantity");
	JLabel lblMarkup = new JLabel("Markup");
	JSeparator separator_1 = new JSeparator();
	JLabel label = new JLabel("Shirt Cost");
	JCheckBox check = new JCheckBox("Flash");
	JLabel lblPrintPrice = new JLabel("Print Price");
	
	JLabel lblSubtotal = new JLabel("Subtotal");
	
	JLabel lblSetup = new JLabel("Setup");
	
	JLabel lblArt = new JLabel("Art");
	JLabel lblTotal = new JLabel("Total");
	JLabel lblPerShirt = new JLabel("Per Shirt");
	
	JFormattedTextField textShirtCost;
	JFormattedTextField textQuantity;
	JFormattedTextField textMarkup;
	JFormattedTextField textArt;
	JFormattedTextField disShirtCost;
	JFormattedTextField disTotal;
	JFormattedTextField disSetup;
	JFormattedTextField disSubtotal;
	JFormattedTextField disPrintPrice;
	JFormattedTextField disPerShirt;
	
	public Application() {
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				requestFocus();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 442);
		
		setTitle("Screen Printing Calculator");
		setIconImage(icon.getImage());
		getContentPane().setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][][grow][][grow][grow][grow][grow][grow][grow][grow]"));
		
		initFormats();
		
        
        
		
		
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		getContentPane().add(lblTitle, "cell 0 0 9 1,alignx center");
		
		
		
		lblLocation1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLocation2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLocation3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		spinner1.setPreferredSize(new Dimension(45,20));
		spinner2.setPreferredSize(new Dimension(45,20));
		spinner3.setPreferredSize(new Dimension(45,20));
		
		spinner1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculate();
			}
		});
		spinner2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculate();
			}
		});
		spinner3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculate();
			}
		});
		
		
		getContentPane().add(lblLocation1, "flowy,cell 3 1,alignx center");
		getContentPane().add(lblLocation2, "flowy,cell 4 1,alignx center");
		getContentPane().add(lblLocation3, "flowy,cell 5 1,alignx center");
		getContentPane().add(spinner1, "cell 3 1,alignx center");
		getContentPane().add(spinner2, "cell 4 1,alignx center");
		getContentPane().add(spinner3, "cell 5 1,alignx center,aligny center");
		

		
		
		getContentPane().add(separator, "cell 0 2 9 1,growx,aligny center");
		
		
		lblShirtCost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblShirtCost, "flowy,cell 3 3,alignx center");
		
		
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblQuantity, "flowy,cell 4 3,alignx center");
		
		
		lblMarkup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblMarkup, "flowy,cell 5 3,alignx center");
		
		
		getContentPane().add(separator_1, "cell 0 4 9 1,growx");
		
		
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(label, "cell 3 5,alignx trailing");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
		});
		
		
		getContentPane().add(check, "cell 5 5,alignx center");
		
		
		lblPrintPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblPrintPrice, "cell 3 6,alignx trailing");
		
		
		
		getContentPane().add(disPrintPrice, "cell 4 6,alignx center");
		
		
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblSubtotal, "cell 3 7,alignx trailing");
		
		
		
		getContentPane().add(textShirtCost, "cell 3 3,alignx center");
		
		
		getContentPane().add(textQuantity, "cell 4 3,alignx center,aligny center");
		
		
		getContentPane().add(textMarkup, "cell 5 3,alignx center");
		
		
		
		getContentPane().add(disSubtotal, "cell 4 7,alignx center");
		
		
		lblSetup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblSetup, "cell 3 8,alignx trailing");
		
		
		
		getContentPane().add(disSetup, "cell 4 8,alignx center");
		
		
		lblArt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblArt, "cell 3 9,alignx trailing");
		
		
		
		getContentPane().add(textArt, "cell 4 9,alignx center");
		
		
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().add(lblTotal, "cell 3 10,alignx trailing");
		
		
		
		getContentPane().add(disShirtCost, "cell 4 5,alignx center");
		
		
		
		getContentPane().add(disTotal, "cell 4 10,alignx center");
		lblPerShirt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		getContentPane().add(lblPerShirt, "cell 3 11,alignx trailing");
		disPerShirt.setPreferredSize(new Dimension(80, 10));
		disPerShirt.setHorizontalAlignment(SwingConstants.CENTER);
		disPerShirt.setEditable(false);
		
		getContentPane().add(disPerShirt, "cell 4 11,alignx center");
	}
	
	public void initFormats() {
		
		NumberFormatter percentEditFormatter =
                new NumberFormatter(numberFormat) {
            public String valueToString(Object o)
                  throws ParseException {
                Number number = (Number)o;
                if (number != null) {
                    double d = number.doubleValue() * 100.0;
                    number = new Double(d);
                }
                return super.valueToString(number);
            }
            public Object stringToValue(String s)
                   throws ParseException {
                Number number = (Number)super.stringToValue(s);
                if (number != null) {
                    double d = number.doubleValue() / 100.0;
                    number = new Double(d);
                }
                return number;
            }
        };
        
		textShirtCost = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat), new NumberFormatter(numberFormat)));
		textMarkup = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(percentFormat), new NumberFormatter(percentFormat),percentEditFormatter));
		textQuantity = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(numberFormat), new NumberFormatter(numberFormat), new NumberFormatter(numberFormat)));
		textArt = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat), new NumberFormatter(numberFormat)));
		disShirtCost = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat)));
		disTotal = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat)));
		disSetup = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat)));
		disSubtotal = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat)));
		disPrintPrice = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat)));
		disPerShirt = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat), new NumberFormatter(currencyFormat)));
		
		textShirtCost.setHorizontalAlignment(JTextField.CENTER);
		textShirtCost.setPreferredSize(new Dimension(80, 10));
		textShirtCost.setValue(shirtPrice);
		textShirtCost.addPropertyChangeListener(new PropertyChangeListener () {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				shirtPrice = ((Number)textShirtCost.getValue()).doubleValue();
				calculate();
			}
		});
		textShirtCost.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                textShirtCost.selectAll();
		            }
		        });
		    }
		});
		
		textMarkup.setHorizontalAlignment(JTextField.CENTER);
		textMarkup.setPreferredSize(new Dimension(80, 10));
		textMarkup.setValue(0);
		textMarkup.addPropertyChangeListener(new PropertyChangeListener () {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				markup = ((Number)textMarkup.getValue()).doubleValue();
				calculate();
			}
		});
		textMarkup.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                textMarkup.selectAll();
		            }
		        });
		    }
		});
		
		textQuantity.setHorizontalAlignment(JTextField.CENTER);
		textQuantity.setPreferredSize(new Dimension(80, 10));
		textQuantity.setValue(quantity);
		textQuantity.addPropertyChangeListener(new PropertyChangeListener () {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				quantity = ((Number)textQuantity.getValue()).intValue();
				calculate();
			}
		});
		textQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                textQuantity.selectAll();
		            }
		        });
		    }
		});
		
		textArt.setHorizontalAlignment(JTextField.CENTER);
		textArt.setPreferredSize(new Dimension(80,10));
		textArt.setValue(0);
		textArt.addPropertyChangeListener(new PropertyChangeListener () {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				art = ((Number)textArt.getValue()).intValue();
				calculate();
			}
		});
		textArt.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                textArt.selectAll();
		            }
		        });
		    }
		});
		
		disPerShirt.setHorizontalAlignment(JTextField.CENTER);
		disPerShirt.setPreferredSize(new Dimension(80,10));
		disPerShirt.setValue(0);
		disPerShirt.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		        SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                disPerShirt.selectAll();
		            }
		        });
		    }
		});
		
		disShirtCost.setEditable(false);
		disShirtCost.setHorizontalAlignment(JTextField.CENTER);
		disShirtCost.setPreferredSize(new Dimension(80,10));
		disShirtCost.setValue(0);
		
		disTotal.setEditable(false);
		disTotal.setHorizontalAlignment(JTextField.CENTER);
		disTotal.setPreferredSize(new Dimension(80,10));
		disTotal.setValue(0);
		
		disSetup.setEditable(false);
		disSetup.setHorizontalAlignment(JTextField.CENTER);
		disSetup.setPreferredSize(new Dimension(80,10));
		disSetup.setValue(0);
		
		disSubtotal.setEditable(false);
		disSubtotal.setHorizontalAlignment(JTextField.CENTER);
		disSubtotal.setPreferredSize(new Dimension(80,10));
		disSubtotal.setValue(0);
		
		disPrintPrice.setEditable(false);
		disPrintPrice.setHorizontalAlignment(JTextField.CENTER);
		disPrintPrice.setPreferredSize(new Dimension(80,10));
		disPrintPrice.setValue(0);
	}
	
	public void calculate() {
		disShirtCost.setValue(getValue(textShirtCost)*(1+markup));
		disPrintPrice.setValue((Calculator.getLocationCost(quantity, (int) getValue(spinner1), check.isSelected())+
							    Calculator.getLocationCost(quantity, (int) getValue(spinner2), check.isSelected())+
							    Calculator.getLocationCost(quantity, (int) getValue(spinner3), check.isSelected()))*(1+markup));
		disSubtotal.setValue(getValue(disShirtCost)+getValue(disPrintPrice));
		disSetup.setValue((getValue(spinner1)+getValue(spinner2)+getValue(spinner3))*12.5*(1+markup));
		disTotal.setValue(getValue(textArt)+(getValue(disSubtotal)*quantity)+getValue(disSetup));
		if(quantity != 0)
			disPerShirt.setValue(getValue(disTotal)/quantity);
	}
	
	public double getValue(JFormattedTextField t) {
		return Double.parseDouble(t.getValue().toString());
	}
	
	public int getValue(JSpinner s) {
		return (int) Double.parseDouble(s.getValue().toString());
	}
}
