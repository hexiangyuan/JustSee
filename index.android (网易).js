'use strict'
import React, {Component}from 'React';
import {
    AppRegistry,
    StyleSheet,
    PiexlRatio,
    Text,
    View,
} from 'react-native';

const Header = require('./header');

class JustSee extends React.Component {
    render() {
        return (
            <View>
                <Header></Header>
                <List title = 'title1'></List>
                <List title = 'title1'></List>
                <List title = 'title1'></List>
                <List title = 'title1'></List>
                <ImportantNews news={[
                    'news0', 'news1', 'news3', 'news4', 'news1news1news1news1news1news1news1news1news1news1news1news1news1news1'
                ]}></ImportantNews>
            </View>
        );
    }
}

class List extends Component {
    render() {
        return (
            <View style={styles.listItem}>
                <Text style = {styles.listItemFont}>{this.props.title}</Text>
            </View>

        );
    }

}

class ImportantNews extends Component {
    show(title) {
        alert(title);
    }

    render() {
        var news = [];
        for (var i in this.props.news) {
            var text = (
                <Text
                    onPress={this.show.bind(this, this.props.news[i]) }
                    numberOfLines={2}
                    style = {styles.listItem}>
                    {this.props.news[i]}</Text>

            );
            news.push(text);
        }

        return (
            <View style = {styles.flex}>
                <Text style = {styles.newsTitle}>今日要闻</Text>
                {news}
            </View>

        );
    }
}

var styles = StyleSheet.create({
    flex: {
        flex: 1,
    },

    listItem: {
        height: 40,
        marginLeft: 12,
        marginRight: 12,
        borderBottomWidth: 1,
        borderBottomColor: '#ddd',
        justifyContent: 'center',
    },

    listItemFont: {
        fontSize: 16,
    },

    newsTitle: {
        height: 40,
        marginLeft: 12,
        marginRight: 12,
        fontSize:20,
        color:'#CD1D1C',
    },


});

AppRegistry.registerComponent('JustSee', () => JustSee);