<?php

class Greeny{
    private $conn;



    function __construct($db){
        $this->conn = $db;
        return $this->conn;
    }



    function time_elapsed_string_az($datetime, $full = false) {
        $now = new DateTime;
        $ago = new DateTime($datetime);
        $diff = $now->diff($ago);

        $diff->w = floor($diff->d / 7);
        $diff->d -= $diff->w * 7;

        $string = array(
            'y' => 'il',
            'm' => 'ay',
            'w' => 'həftə',
            'd' => 'gün',
            'h' => 'saat',
            'i' => 'dəqiqə',
            's' => 'saniyə',
        );
        foreach ($string as $k => &$v) {
            if ($diff->$k) {
                $v = $diff->$k . ' ' . $v . ($diff->$k > 1 ? '' : '');
            } else {
                unset($string[$k]);
            }
        }

        if (!$full) $string = array_slice($string, 0, 1);
        return $string ? implode(', ', $string) . ' əvvəl' : 'indice';
    }

    function search($keywords){
        $query = "SELECT * FROM plants  WHERE plantName LIKE ? OR kindOfSoil LIKE ?";
        $stmt = $this->conn->prepare($query);
        $keywords=htmlspecialchars(strip_tags($keywords));
        $keywords = "%".$keywords."%";
        $stmt->bindParam(1, $keywords);
        $stmt->bindParam(2, $keywords);

        $stmt->execute();
        return $stmt;
    }




}




?>