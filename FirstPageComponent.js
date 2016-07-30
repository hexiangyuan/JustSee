'use strict'
import React from 'react';
import {
  View,
  Navigator,
  TouchableOpacity,Text,StyleSheet,
} from 'react-native';

import Header from './header';

export default class FirstPageComponent extends React.Component{
  constructor(props){
    super(props);
    this.state={
    };
  }

_pressButton(){
  const {navigator} = this.props;
  if(navigator){
    navigator.push({
        name:'Header',
        component:Header,
        params:{
          id:2
        },
    })
  }
}
  render(){
    return(
    <View style = {styles.text}>
      <TouchableOpacity onPress={this._pressButton.bind(this)}>
        <Text>点我跳转</Text>
      </TouchableOpacity>
    </View>
  );
}
}
var styles = StyleSheet.create({
  text:{
    paddingTop:64,
  },
});
