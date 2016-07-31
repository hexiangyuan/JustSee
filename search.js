'use strict'

import React from 'react';
import {
    View,
    TextInput,
    Text,
    StyleSheet,
    PiexlRatio,
    TouchableOpacity,
} from 'react-native';

export default class Search extends React.Component {
    render() {
        return (
          <View style={[styles.flex, styles.flexDirection]}>
            <View style = {styles.input}>
              <TextInput
                placeholder = "Enter text to see events"
                style = {styles.text}>
            </TextInput>
            </View>
            <TouchableOpacity onProgress >
              <View style = {[styles.btn]}>
                <Text style = {
                  styles.btnText
                  }> 搜索 </Text>
                </View>
             </TouchableOpacity>
            </View>
        );
    }
}

var styles = StyleSheet.create({
    flex: {
        flex: 1,
    },
    flexDirection: {
        flexDirection: 'row',
    },
    input: {
        borderRadius: 2,
        borderWidth:1,
        borderBottomColor: 'black',
        height: 50,
        flex: 1
    },
    text: {
        fontSize: 16,
        color: '#333333',
    },
    btn: {
        backgroundColor: 'blue',
        width: 80,
        height: 50,
    },
    btnText: {
        fontSize: 16,
        color: '#FFFFFF',
    },
});
