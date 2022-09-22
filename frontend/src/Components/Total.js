import React from "react";
import accounting from "accounting";
import { Button, makeStyles } from "@material-ui/core";

const useStyles = makeStyles((theme) =>({

    root: {
        display: "flex",
        flexDirection:"column",
        justifyContent: "center",
        alignItems: "center",
        height: "20vh"
    },
    Button:{
        marginTop: "2rem"
    }

}))

const Total = () => {
    const classes = useStyles()
    return(
        <div className={classes.root}>
            <h4>Mi Carrito</h4>
            <h6>Cant. de Art: 5</h6>
            <h5>Total: {accounting.formatMoney(50, "$")}</h5>
            <Button className={classes.Button} variant="contained" color="primary"> Comprar </Button>
        </div>

    )
}
export default Total