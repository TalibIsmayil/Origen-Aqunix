<?php



class Database{


    private $host = 'localhost';
    private $username = 'tamtcqkw';
    private $password = 'C51#[SNwze91gV';
    private $db_name   = 'tamtcqkw_greeny';
    public $conn;


    public function getConnection(){

        $this->conn  =null;
        try {
            $this->conn = new PDO("mysql:host=" . $this->host . ";dbname=" . $this->db_name.";charset=utf8", $this->username, $this->password,array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
            $this->conn->exec("set names utf8");

        } catch (PDOException $exception) {
            echo $exception->getMessage();
        }

        return $this->conn;

    }


}

?>