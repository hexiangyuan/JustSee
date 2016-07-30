'use strict'

import React from 'react';
import {
    AppRegistry,
    Image,
    ListView,
    StyleSheet,
    Text,
    View,
} from 'react-native';

var REQUEST_URL = 'http://www.65emall.net:8051/SG_android.ashx';

class JustSee extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            dataSource: new ListView.DataSource({
                rowHasChanged: (row1, row2) => row1 !== row2,
            }),
            loaded: false,
        };
    }

    componentDidMount() {
        this.fetchData();
    }

    fetchData() {
        fetch(REQUEST_URL, {
            method: 'POST',
        
            body: JSON.stringify({
                id: '15',
                params: [0, 0, 20],
                method: 'Category.GetPrimeProducts'
            })
        })
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    dataSource: this.state.dataSource.cloneWithRows(responseData.result),
                    loaded: true,
                });
            })
            .done();
    }

    render() {
        if (!this.state.loaded) {
            return this.renderLoadingView();
        }

        return (
            <ListView
                dataSource={this.state.dataSource}
                renderRow={this.renderMovie}
                contentContainerStyle={styles.listView}
            />
        );
    }

    renderLoadingView() {
        return (
            <View style={styles.container}>
                <Text>
                    Loading movies...
                </Text>
            </View>
        );
    }

    renderMovie(item) {
        return (
            <View style={styles.container_}>
                <Image
                    source={{uri: item.picture}}
                    style={styles.thumbnail_}
                />
                <View style={styles.rightContainer}>
                    <Text style={styles.title_}>{item.name}</Text>
                    <Text style={styles.price_}>{item.price}</Text>
                </View>
            </View>
        );
    }
}

var styles = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    rightContainer: {
        width:200,
        flex: 1,
    },
    title: {
        fontSize: 20,
        marginBottom: 8,
        textAlign: 'center',
    },
    year: {
        textAlign: 'center',
    },
    thumbnail: {
        width: 53,
        height: 81,
    },
    listView: {
        flexDirection:'row',
        flexWrap:'wrap',
        paddingTop: 20,
        backgroundColor: '#F5FCFF',
    },

    container_: {
      padding:8, flexDirection: 'column', justifyContent: 'center', backgroundColor: '#F5fcff',width:180,
    },
    title_: {
        fontSize: 12, marginTop: 8, color: 'black', textAlign: 'left',
    },
    price_: {
        fontSize: 16, marginTop: 8, color: 'blue', textAlign: 'left',
    },
    thumbnail_: {
        width: 180,
        height:240,
    },
});

AppRegistry.registerComponent('JustSee', () => JustSee);