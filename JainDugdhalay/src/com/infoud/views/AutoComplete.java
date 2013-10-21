package com.infoud.views;



import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
 
public class AutoComplete extends JComboBox implements JComboBox.KeySelectionManager
{
 private String searchFor;
 private long lap;
 public class CBDocument extends PlainDocument
 {
 @Override
 public void insertString(int offset, String str, AttributeSet a) throws BadLocationException
 {
 if (str==null) return;
 super.insertString(offset, str, a);
 if(!isPopupVisible() && str.length() != 0) fireActionEvent();
 }
 }
 public AutoComplete(Object[] items)
 {
 super(items);
 lap = new java.util.Date().getTime();
 setKeySelectionManager(this);
 JTextField tf;
 if(getEditor() != null)
 {
 tf = (JTextField)getEditor().getEditorComponent();
 if(tf != null)
 {
 tf.setDocument(new CBDocument());
 addActionListener(new ActionListener()
 {
 public void actionPerformed(ActionEvent evt)
 {
 JTextField tf = (JTextField)getEditor().getEditorComponent();
 String text = tf.getText();
 
 ComboBoxModel aModel = getModel();
 
 String current;
 for(int i = 0; i < aModel.getSize(); i++)
 {
 current = aModel.getElementAt(i).toString();
 if(current.toLowerCase().startsWith(text.toLowerCase()))
 {
 tf.setText(current);
 tf.setSelectionStart(text.length());
 tf.setSelectionEnd(current.length());

 break;
 }
 }
 }
 });
 }
 }
 }
 public int selectionForKey(char aKey, ComboBoxModel aModel)
 {
 long now = new java.util.Date().getTime();
 if (searchFor!=null && aKey==KeyEvent.VK_BACK_SPACE && searchFor.length()>0)
 {
 searchFor = searchFor.substring(0, searchFor.length() -1);
 }
 else
 {
 if(lap + 1000 < now)
 searchFor = "" + aKey;
 else
 searchFor = searchFor + aKey;
 }
 lap = now;
 String current;
 for(int i = 0; i < aModel.getSize(); i++)
 {
 current = aModel.getElementAt(i).toString().toLowerCase();
 if (current.toLowerCase().startsWith(searchFor.toLowerCase())) return i;
 }
 return -1;
 }
 
 @Override
 public void fireActionEvent()
 {
 super.fireActionEvent();
 }
 
public static void main(String arg[])
 {
 JFrame f = new JFrame("AutoCompletion");
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 f.setSize(300,50);
 Container cp= f.getContentPane();
 cp.setLayout(new GridLayout(1, 1));
 
 String[] Customer = new String[]{"Harsh","Nayan","Nishant","Sanket","Vaibhav"};
 //JComboBox 1 allowing any input
 JComboBox cBox= new AutoComplete(Customer);
 
 
 

 cBox.setBounds(50,50,100,21);
 cBox.setEditable(true);
 cp.add(cBox);

 f.setVisible(true);
 f.setResizable(false);
 f.setLocationRelativeTo(null);
 }
}