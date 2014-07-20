package com.wsoft.controller;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JToggleButton;
import javax.swing.text.JTextComponent;

import com.wsoft.view.BaseForm;

public abstract class FormCtrl extends BaseCtrl {
	public void create() {
		BaseForm frame = (BaseForm) this.view;
		this.unlockAllfields(frame);
		this.enableAllfields(frame);
		frame.newBtn.setEnabled(false);
		frame.firstBtn.setEnabled(false);
		frame.lastBtn.setEnabled(false);
		frame.previousBtn.setEnabled(false);
		frame.searchBtn.setEnabled(false);
		frame.nextBtn.setEnabled(false);
		frame.deleteBtn.setEnabled(false);
		frame.changeBtn.setEnabled(false);
	}

	public abstract void delete();

	public abstract void search();
	
	public void save(){
		BaseForm frame = (BaseForm) this.view;
		this.disableAllfields(frame);
		this.lockAllfields(frame);
		frame.newBtn.setEnabled(true);
		frame.firstBtn.setEnabled(true);
		frame.lastBtn.setEnabled(true);
		frame.previousBtn.setEnabled(true);
		frame.searchBtn.setEnabled(true);
		frame.nextBtn.setEnabled(true);
		frame.deleteBtn.setEnabled(true);
		frame.changeBtn.setEnabled(true);
	}

	
	public void change() {
		this.create();
	}

	public void first() {
		BaseForm frame = (BaseForm) this.view;
		this.disableAllfields(frame);
		this.lockAllfields(frame);
	}

	public abstract void previous();

	public abstract void next();

	public abstract void last();

	public abstract List<JTextComponent> alwaysLocked();

	public abstract List<JToggleButton> alwaysDisabled();

	private void unlockAllfields(BaseForm baseForm) {
		Field[] fields = baseForm.getClass().getFields();
		for (Field field : fields) {
			try {
				Object object = field.get(baseForm);
				if (object instanceof JTextComponent) {
					JTextComponent component1 = (JTextComponent) object;
					boolean shouldUnlock = true;
					if(alwaysLocked() != null){
						for (JTextComponent component : alwaysLocked()) {
							if (component.equals(component1))
								shouldUnlock = false;
						}
					}
					if (shouldUnlock)
						component1.setEditable(true);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private void lockAllfields(BaseForm baseForm) {
		Field[] fields = baseForm.getClass().getFields();
		for (Field field : fields) {
			try {
				Object object = field.get(baseForm);
				if (object instanceof JTextComponent) {
					JTextComponent component1 = (JTextComponent) object;
					component1.setEditable(false);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private void disableAllfields(BaseForm baseForm) {
		Field[] fields = baseForm.getClass().getFields();
		for (Field field : fields) {
			try {
				Object object = field.get(baseForm);
				if (object instanceof JToggleButton) {
					JToggleButton component1 = (JToggleButton) object;
					component1.setEnabled(false);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private void enableAllfields(BaseForm baseForm) {
		Field[] fields = baseForm.getClass().getFields();
		for (Field field : fields) {
			try {
				Object object = field.get(baseForm);
				if (object instanceof JToggleButton) {
					JToggleButton component1 = (JToggleButton) object;
					boolean shouldUnlock = true;
					if (alwaysDisabled() != null) {
						for (JToggleButton component : alwaysDisabled()) {
							if (component.equals(component1))
								shouldUnlock = false;
						}
					}
					if (shouldUnlock)
						component1.setEnabled(true);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}
