const path = require('path');
const glob = require("glob");

module.exports = {
    mode: 'development',
    entry: {
        main: ['./src/main/content/jcr_root/etc/designs/aem-ktln/clientlib-site/js/script.js']
    },
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, './target/classes/etc/designs/aem-ktln/clientlib-site/js')
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['es2015']
                    }
                }
            }
        ]
    },
    resolve: {
        alias: {
            'vue': 'vue/dist/vue.js',
        }
    },
    devtool: 'inline-source-map'

};