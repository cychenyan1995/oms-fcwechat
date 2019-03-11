function sortNumber(a, b) {
    return a - b
}

function buildChart(dailyData, monthData) {
    //找出最大流量的天
    var arr = new Array();
    var chartWidth = $('#chart').width() - 30;
    for (var i = 0; i < dailyData.length; i++) {
        var data = dailyData[i];
        arr[i] = data[1]
    }

    var maxIndex;
    arr = arr.sort(sortNumber);
    var maxValue = arr[dailyData.length - 1];

    for (var i = 0; i < dailyData.length; i++) {
        var data = dailyData[i];
        if (maxValue == data[1]) {
            maxIndex = i;
            break;
        }
    }

    arr = new Array()
    for (var i = 0; i < monthData.length; i++) {
        var data = monthData[i];
        arr[i] = data[1]
    }
    var monthMaxIndex;
    arr = arr.sort(sortNumber);
    var monthMaxValue = arr[monthData.length - 1];

    for (var i = 0; i < monthData.length; i++) {
        var data = monthData[i];
        if (monthMaxValue == data[1]) {
            monthMaxIndex = i;
            break;
        }
    }

    /* chart */
    var aDailyData = [],
        aMonthData = [];
    dailyData.forEach(function(item) {
        aDailyData.push(item[0]);
    });
    monthData.forEach(function(item) {
        aMonthData.push(item[0]);
    });
    var linearGradient = new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
        offset: 0,
        color: '#FFF0BF'
    }, {
        offset: 0.4,
        color: '#FFE28E'
    }, {
        offset: 1,
        color: '#F9B450'
    }]);
    var ttConfig = {
        edge: false,
        s: null,
        d: null,
        pt: []
    };
    var option = {
        animation: true,
        legend: {
            show: false,
            selectedMode: 'single',
            data: ['月走势', '日走势'],
            selected: {
                '月走势': false,
                '日走势': true
            }
        },
        tooltip: {
            position: function(pt, series, dom, c, size) {
                var offset, max, left, $dom, newEdge = '';
                series = series[0];
                max = option.series[series.seriesIndex].data.length;

                if (series.dataIndex === 0 && max >= 2) {
                    newEdge = 'left';
                    offset = -6;
                } else if (series.dataIndex === max - 1 && max >= 2) {
                    newEdge = 'right';
                    offset = -(size.contentSize[0] - 8);
                } else {
                    offset = -(size.contentSize[0] / 2);
                }

                if (max === 1) {
                    left = chartWidth / 2;
                } else {
                    left = chartWidth / (max - 1) * series.dataIndex;
                }

                if (newEdge || ttConfig.edge) {
                    $dom = $(dom).find('.tooltip-box').removeClass(ttConfig.edge).addClass(newEdge);
                }

                ttConfig.pt = [left + offset + 14, 10];
                ttConfig.s = series.seriesIndex;
                ttConfig.d = series.dataIndex;
                ttConfig.edge = newEdge;

                return ttConfig.pt;
            },
            trigger: 'axis',
            showContent: true,
            alwaysShowContent: true,
            backgroundColor: '#FF6F00',
            formatter: function(series) {
                var unit = (series[0].seriesIndex === 0) ? '' : '月';
                var html = '<div class="tooltip-box">' +
                    '<div class="value">' +
                    series[0].value[1] + 'M' +
                    '</div>' +
                    '<div class="date">' +
                    series[0].value[0].substring(6) + unit +
                    '</div>' +
                    '</div>';
                return html
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            axisPointer: {
                value: new Date(),
                snap: true,
                lineStyle: {
                    color: '#63A7F5',
                    width: 1.5
                },
                label: {
                    show: false
                },
                handle: {
                    show: true,
                    color: '#004E52',
                    margin: -50,
                    icon: 'image:../../images/chart_handle.png'
                }
            },
            axisTick: {
                show: false
            },
            data: aDailyData,
            axisLabel: {
                show: true,
                formatter: function(time) {
                    var date = new Date(time);
                    var labelStr;
                    if (myChart.getOption().legend[0].selected['日走势']) {
                        labelStr = [date.getMonth() + 1, date.getDate()].join('/');
                    } else {
                        labelStr = date.getMonth() + 1 + '月';
                    }
                    return labelStr;
                },
                textStyle: {
                    color: '#666',
                    fontSize: 10
                },
                interval: function(index, value) {
                    if (index === 0) {
                        return true;
                    }
                    return false;
                }
            },
            splitLine: {
                show: false
            }
        },
        yAxis: [{
            type: 'value',
            axisTick: {
                show: false
            },
            splitLine: {
                show: true,
                lineStyle: {
                    color: '#e5e5e5'
                }
            },
            axisLabel: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#eee'
                }
            },
            z: 10
        }, {
            type: 'value',
            axisTick: {
                show: false
            },
            splitLine: {
                show: true,
                lineStyle: {
                    color: '#e5e5e5'
                }
            },
            axisLabel: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#eee'
                }
            },
            z: 10
        }],
        grid: {
            top: 70,
            left: 15,
            right: 15,
            height: 130
        },
        dataZoom: [{
            type: 'inside',
            throttle: 50
        }],
        series: [{
            name: '日走势',
            type: 'line',
            smooth: true,
            showSymbol: false,
            sampling: 'average',
            itemStyle: {
                normal: {
                    color: '#FEBF2C'
                }
            },
            lineStyle: {
                width: 1.5
            },
            stack: 'a',
            areaStyle: {
                normal: {
                    color: linearGradient
                }
            },
            data: dailyData
        }, {
            name: '月走势',
            type: 'line',
            smooth: true,
            showSymbol: false,
            sampling: 'average',
            itemStyle: {
                normal: {
                    color: '#FEBF2C'
                }
            },
            stack: 'a',
            areaStyle: {
                normal: {
                    color: linearGradient
                }
            },
            data: monthData
        }],
        noDataLoadingOption: {
            effect: 'bubble'
        }
    };

    var dom = document.getElementById("chart");
    var myChart = echarts.init(dom);
    myChart.clear();
    myChart.setOption(option, true);

    $('#chartChange').on('click', 'button', function() {
        myChart.dispatchAction({
            type: 'legendSelect',
            name: $(this).text()
        });
        tiggerTooltip($(this).text());
        $(this).parent().find('button').toggleClass('active');
    });

    function tiggerTooltip(name) {
        setTimeout(function() {
            var dataIndex, seriesIndex, data;
            var offsetOpt = {
                xAxis: {
                    axisLabel: {
                        interval: function(index, value) {
                            return (index === 0 || index === (offsetOpt.xAxis.data.length - 1));
                        }
                    }
                }
            };
            if (name == '日走势') {
                offsetOpt.xAxis.data = aDailyData;
                data = dailyData || [];
                dataIndex = maxIndex;
                seriesIndex = 0;
            } else {
                offsetOpt.xAxis.data = aMonthData;
                data = monthData || [];
                dataIndex = monthMaxIndex;
                seriesIndex = 1;
            }
            if (data.length > 0) {
                $(dom).show();
                myChart.setOption(offsetOpt);
                myChart.dispatchAction({
                    type: 'showTip',
                    seriesIndex: seriesIndex,
                    dataIndex: dataIndex
                });
            } else {
                $(dom).hide();
            }
        }, 10);
    }
    tiggerTooltip('日走势');

}
