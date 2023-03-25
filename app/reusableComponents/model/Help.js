import React from 'react'
import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogContentText,
    DialogTitle
} from '@material-ui/core'
import { PropTypes } from 'prop-types'

export const HelpButton = ({ isOpen,handleClose, title, subtitle, children}) => {

    return (
    <>
        <Dialog
            fullWidth
            maxwigth='md'
            open={isOpen}
            onclose={handleClose}
            aeia-labelledby='max-width-dialog-title'
        >
            <DialogTitle id='max-width-dailog-title'>{title}</DialogTitle>
            <DialogContent>
                <DialogContentText>{subtitle}</DialogContentText>
                {children}
            </DialogContent>
            <DialogActions>
                <Button onClick={handleClose} color='primary'>
                    close
                </Button>
            </DialogActions>
        </Dialog>
    </>
    );
}

HelpButton.PropTypes = {
    isOpen: PropTypes.bool.isrequired,
    handleClose: PropTypes.func.isrequired,
    title: PropTypes.string.isrequired,
    subtitle: PropTypes.string,
    children: PropTypes.element.isrequired
}