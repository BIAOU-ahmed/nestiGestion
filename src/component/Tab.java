/**
 * 
 */
package component;

import javax.swing.JPanel;

/**
 * @author ahmed
 *
 */
public abstract class Tab extends JPanel {

	private static final long serialVersionUID = 1L;

public  void refreshTab() {
	this.removeAll();
}
}
