<?php
header('Access-Control-Origin-Allow:*');
header('Content-Type:application/json;charset');
header('Access-Control-Allow-Methods:POST');
header('Access-Control-Max-Age:3600');
header('Access-Control-Allow-Headers:Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With');


$deviceAdresses  = [['name'=>'Crop Management',
                'mac'=>'00:10:FA:6E:38:4A' ],
    ['name'=>'Crop Management',
        'mac'=>'00:10:FA:6E:38:4A' ],
    ['name'=>'Farmapp',
        'mac'=>'00:10:FA:6E:38:4A' ],
    ['name'=>'Growlink',
        'mac'=>'00:10:FA:6E:38:4A' ],
    ['name'=>'Greeniq',
        'mac'=>'00:10:FA:6E:38:4A' ],
    ['name'=>'Arable',
        'mac'=>'00:10:FA:6E:38:4A' ],
    ['name'=>'Semios',
        'mac'=>'00:10:FA:6E:38:4A' ],
    ['name'=>'SCR by arflexx',
        'mac'=>'00:10:FA:6E:38:4A' ],
    ['name'=>'Cropio',
        'mac'=>'00:10:FA:6E:38:4A' ],
    ['name'=>'Farm logs',
        'mac'=>'00:10:FA:6E:38:4A' ],
];

echo json_encode($deviceAdresses,JSON_UNESCAPED_UNICODE);


