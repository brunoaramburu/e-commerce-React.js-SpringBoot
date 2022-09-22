import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import clsx from 'clsx';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import DeleteIcon from '@material-ui/icons/Delete'
import{ AddShoppingCart } from '@material-ui/icons'
import accounting from 'accounting';

const useStyles = makeStyles((theme) => ({
  root: {
    maxWidth: 300,
    marginLeft: "4rem", 
  },
  action:{
    marginTop: "2rem",
  },
  media: {
    height: 0,
    paddingTop: '100%', // 16:9
  },
  CardActions: {
    display: "flex",
    justifyContent: "flex-end"
},
    }));

export default function CheckoutCard({product : {id, cod, descripcion, precio, image, detalle, pie, info}}) {
  const classes = useStyles();
  const [expanded, setExpanded] = React.useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  return (
    <Card className={classes.root}>
      <CardHeader
            action={
                <Typography
                className={classes.action}
                variant='h5'
                >
                {accounting.formatMoney(precio, "$")}
                
            </Typography>
        }
        title= {descripcion}
        subheader={cod}
      />
      <CardMedia
        className={classes.media}
        image={image}
        title={detalle}
      />
      <CardContent>
        <Typography variant="body2" color="textSecondary" component="p">
        {pie}
        </Typography>
      </CardContent>
    
      <CardActions disableSpacing className={classes.CardActions}>
        <IconButton>
          <DeleteIcon fontSize='large'/>
        </IconButton>
      </CardActions>
    </Card>
  );
}
