module.exports = function() {
    return Object.assign({},
        require('./routes/algorithms.json'),
        require('./routes/calculate_path.json')
    );
}