'use strict'

import React from 'react';
import {
    AppRegistry,
    StyleSheet,
    PiexlRatio,
    Text,
    View,
} from 'react-native';


class Header extends React.Component {
    render() {
        return (
            <View style={styles.flex}>
                <Text style={styles.font}>
                    <Text style={styles.fontWangyi}>网易</Text>
                    <Text style={styles.fontXinWen}>新闻</Text>
                    <Text style={styles.font}>有态度“</Text>
                </Text>
            </View>
        );
    }
}

var styles = StyleSheet.create({
    container: {
        flex: 1,
        height: 84,
        marginTop: 200,
        marginLeft: 12,
        marginRight: 12,
        borderRadius: 5,
        padding: 2,
        backgroundColor: '#FF0067',
        flexDirection: 'row',
    },
    item: {
        flex: 1,
        height: 80,
    },
    center: {
        justifyContent: 'center',
        alignItems: 'center',
    },

    flex: {
        marginTop: 25,
        height:50,
        borderBottomWidth: 3,
        borderBottomColor: '#EF2D36',
        alignItems: 'center',

    },

    font: {
        textAlign: 'center',
        fontSize: 25,
        fontWeight: 'bold',
    },

    fontWangyi: {
        color: '#CD1D1C',
    },

    fontXinWen: {
        backgroundColor: '#CD1D1C',
        color: '#FFF',
        paddingLeft:2,
        paddingRight:2,
    },

    fontYouTaiDu: {
        color: '#666666',
    },

});

module.exports = Header; 