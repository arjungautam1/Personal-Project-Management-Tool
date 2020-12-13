import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";

export default function AddProjectMaterial() {
  const [open, setOpen] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      {/*<Button variant="outlined" color="primary" onClick={handleClickOpen}>*/}
      {/*  OpenDialog*/}
      {/*</Button>*/}
      <Button
        variant="contained"
        color="primary"
        onClick={handleClickOpen}
        disabledElevation
      >
        Create New Project
      </Button>
      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="form-dialog-title"
      >
        <DialogTitle id="form-dialog-title">Create / Edit Project</DialogTitle>
        <DialogContent>
          <DialogContentText>Create New Project</DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="Project Name"
            type="email"
            fullWidth
          />
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="Unique Project ID"
            type="email"
            fullWidth
          />
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="Project Description "
            type="email"
            fullWidth
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Submit
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
