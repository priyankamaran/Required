
import { Component,Inject} from '@angular/core';
import {MdFormField,MdButton,MdInput,MdDialog, MdDialogRef, MD_DIALOG_DATA} from '@angular/material';


@Component({
    selector: 'dialog-overview-example-dialog',
    templateUrl: './dialog-overview-example-dialog.html',
  })
  export class DialogOverviewExampleDialog {
  
    constructor(
      public dialogRef: MdDialogRef<DialogOverviewExampleDialog>,
      @Inject(MD_DIALOG_DATA) public data: any) { }
  
    onNoClick(): void {
      this.dialogRef.close();
    }
  
  }
  