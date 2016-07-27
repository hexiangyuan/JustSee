'use strict';
import React from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View
}from 'react-native';

class JustSee extends React.Component {
    render() {
        return (
            <View style = {styles.container}>
                <Text style={styles.text}>Just See</Text>
            </View>
        )
    }
}

var styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
    },
    text: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
});
AppRegistry.registerComponent('JustSee', () => JustSee);