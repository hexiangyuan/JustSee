'use strict'

import React from 'react';
import {
    AppRegistry,
    Image,
    ListView,
    StyleSheet,
    PiexlRatio,
    Text,
    View,
} from 'react-native';

var REQUEST_URL = 'http://www.65emall.net:8051/SG_android.ashx';

class JustSee extends React.Component {
    render() {
        return (
            <View>
                <View style={styles.container}>
                    <View style={[styles.item, styles.center]}>
                        <Text style={styles.font}>酒店</Text>
                    </View>

                    <View style={[styles.item, styles.lineLeftRight]}>
                        <View style={[styles.flex, styles.center, styles.lineBotton]}>
                            <Text style={styles.font}>酒店</Text>
                        </View>
                        <View style={[styles.flex, styles.center]}>
                            <Text style={styles.font}>酒店</Text>
                        </View>
                    </View>

                    <View style={styles.item}>
                        <View style={[styles.flex, styles.center, styles.lineBotton]}>
                            <Text style={styles.font}>酒店</Text>
                        </View>
                        <View style={[styles.flex, styles.center]}>
                            <Text style={styles.font}>酒店</Text>
                        </View>
                    </View>
                </View>
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
        flex: 1,

    },
    font: {
        color: '#FFFFFF',
        fontSize: 16,
        fontWeight: 'bold',
    },
    lineLeftRight: {
        borderLeftWidth: 1,
        borderRightWidth: 1,
        borderColor: '#FFFFFF',
    },
    lineBotton: {
        borderBottomWidth: 1,
        borderColor: '#FFFFFF',
    }
});

AppRegistry.registerComponent('JustSee', () => JustSee);