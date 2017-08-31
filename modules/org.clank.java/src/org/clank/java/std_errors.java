/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clank.java;

import static org.clank.java.errno_codes.E2BIG;
import static org.clank.java.errno_codes.EACCES;
import static org.clank.java.errno_codes.EADDRINUSE;
import static org.clank.java.errno_codes.EADDRNOTAVAIL;
import static org.clank.java.errno_codes.EADV;
import static org.clank.java.errno_codes.EAFNOSUPPORT;
import static org.clank.java.errno_codes.EAGAIN;
import static org.clank.java.errno_codes.EALREADY;
import static org.clank.java.errno_codes.EBADE;
import static org.clank.java.errno_codes.EBADF;
import static org.clank.java.errno_codes.EBADFD;
import static org.clank.java.errno_codes.EBADMSG;
import static org.clank.java.errno_codes.EBADR;
import static org.clank.java.errno_codes.EBADRQC;
import static org.clank.java.errno_codes.EBADSLT;
import static org.clank.java.errno_codes.EBFONT;
import static org.clank.java.errno_codes.EBUSY;
import static org.clank.java.errno_codes.ECANCELED;
import static org.clank.java.errno_codes.ECHILD;
import static org.clank.java.errno_codes.ECHRNG;
import static org.clank.java.errno_codes.ECOMM;
import static org.clank.java.errno_codes.ECONNABORTED;
import static org.clank.java.errno_codes.ECONNREFUSED;
import static org.clank.java.errno_codes.ECONNRESET;
import static org.clank.java.errno_codes.EDEADLK;
import static org.clank.java.errno_codes.EDEADLOCK;
import static org.clank.java.errno_codes.EDESTADDRREQ;
import static org.clank.java.errno_codes.EDOM;
import static org.clank.java.errno_codes.EDQUOT;
import static org.clank.java.errno_codes.EEXIST;
import static org.clank.java.errno_codes.EFAULT;
import static org.clank.java.errno_codes.EFBIG;
import static org.clank.java.errno_codes.EHOSTDOWN;
import static org.clank.java.errno_codes.EHOSTUNREACH;
import static org.clank.java.errno_codes.EIDRM;
import static org.clank.java.errno_codes.EILSEQ;
import static org.clank.java.errno_codes.EINPROGRESS;
import static org.clank.java.errno_codes.EINTR;
import static org.clank.java.errno_codes.EINVAL;
import static org.clank.java.errno_codes.EIO;
import static org.clank.java.errno_codes.EISCONN;
import static org.clank.java.errno_codes.EISDIR;
import static org.clank.java.errno_codes.EL2HLT;
import static org.clank.java.errno_codes.EL2NSYNC;
import static org.clank.java.errno_codes.EL3HLT;
import static org.clank.java.errno_codes.EL3RST;
import static org.clank.java.errno_codes.ELIBACC;
import static org.clank.java.errno_codes.ELIBBAD;
import static org.clank.java.errno_codes.ELIBEXEC;
import static org.clank.java.errno_codes.ELIBMAX;
import static org.clank.java.errno_codes.ELIBSCN;
import static org.clank.java.errno_codes.ELNRNG;
import static org.clank.java.errno_codes.ELOCKUNMAPPED;
import static org.clank.java.errno_codes.ELOOP;
import static org.clank.java.errno_codes.EMFILE;
import static org.clank.java.errno_codes.EMLINK;
import static org.clank.java.errno_codes.EMSGSIZE;
import static org.clank.java.errno_codes.EMULTIHOP;
import static org.clank.java.errno_codes.ENAMETOOLONG;
import static org.clank.java.errno_codes.ENETDOWN;
import static org.clank.java.errno_codes.ENETRESET;
import static org.clank.java.errno_codes.ENETUNREACH;
import static org.clank.java.errno_codes.ENFILE;
import static org.clank.java.errno_codes.ENOANO;
import static org.clank.java.errno_codes.ENOBUFS;
import static org.clank.java.errno_codes.ENOCSI;
import static org.clank.java.errno_codes.ENODATA;
import static org.clank.java.errno_codes.ENODEV;
import static org.clank.java.errno_codes.ENOENT;
import static org.clank.java.errno_codes.ENOEXEC;
import static org.clank.java.errno_codes.ENOLCK;
import static org.clank.java.errno_codes.ENOLINK;
import static org.clank.java.errno_codes.ENOMEM;
import static org.clank.java.errno_codes.ENOMSG;
import static org.clank.java.errno_codes.ENONET;
import static org.clank.java.errno_codes.ENOPKG;
import static org.clank.java.errno_codes.ENOPROTOOPT;
import static org.clank.java.errno_codes.ENOSPC;
import static org.clank.java.errno_codes.ENOSR;
import static org.clank.java.errno_codes.ENOSTR;
import static org.clank.java.errno_codes.ENOSYS;
import static org.clank.java.errno_codes.ENOTACTIVE;
import static org.clank.java.errno_codes.ENOTBLK;
import static org.clank.java.errno_codes.ENOTCONN;
import static org.clank.java.errno_codes.ENOTDIR;
import static org.clank.java.errno_codes.ENOTEMPTY;
import static org.clank.java.errno_codes.ENOTRECOVERABLE;
import static org.clank.java.errno_codes.ENOTSOCK;
import static org.clank.java.errno_codes.ENOTSUP;
import static org.clank.java.errno_codes.ENOTTY;
import static org.clank.java.errno_codes.ENOTUNIQ;
import static org.clank.java.errno_codes.ENXIO;
import static org.clank.java.errno_codes.EOPNOTSUPP;
import static org.clank.java.errno_codes.EOVERFLOW;
import static org.clank.java.errno_codes.EOWNERDEAD;
import static org.clank.java.errno_codes.EPERM;
import static org.clank.java.errno_codes.EPFNOSUPPORT;
import static org.clank.java.errno_codes.EPIPE;
import static org.clank.java.errno_codes.EPROTO;
import static org.clank.java.errno_codes.EPROTONOSUPPORT;
import static org.clank.java.errno_codes.EPROTOTYPE;
import static org.clank.java.errno_codes.ERANGE;
import static org.clank.java.errno_codes.EREMCHG;
import static org.clank.java.errno_codes.EREMOTE;
import static org.clank.java.errno_codes.ERESTART;
import static org.clank.java.errno_codes.EROFS;
import static org.clank.java.errno_codes.ESHUTDOWN;
import static org.clank.java.errno_codes.ESOCKTNOSUPPORT;
import static org.clank.java.errno_codes.ESPIPE;
import static org.clank.java.errno_codes.ESRCH;
import static org.clank.java.errno_codes.ESRMNT;
import static org.clank.java.errno_codes.ESTALE;
import static org.clank.java.errno_codes.ESTRPIPE;
import static org.clank.java.errno_codes.ETIME;
import static org.clank.java.errno_codes.ETIMEDOUT;
import static org.clank.java.errno_codes.ETOOMANYREFS;
import static org.clank.java.errno_codes.ETXTBSY;
import static org.clank.java.errno_codes.EUNATCH;
import static org.clank.java.errno_codes.EUSERS;
import static org.clank.java.errno_codes.EXDEV;
import static org.clank.java.errno_codes.EXFULL;
import static org.clank.java.io.setErrno;
import static org.clank.java.std.min;
import org.clank.support.*;
import org.clank.support.Native;
import static org.clank.support.Native.*;
import static org.clank.support.NativeCallback.unspecified_bool_true;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;

/**
 *
 * @author ilia
 */
public class std_errors implements errno_codes {
  
  private static final _generic_error_category GENERIC_ERROR_CATEGORY/*J*/= new _generic_error_category();
  
  public static /*const*/error_category /*&*/ generic_category() {
    return GENERIC_ERROR_CATEGORY;
  }
  
  private static final _system_error_category SYSTEM_ERROR_CATEGORY/*J*/= new _system_error_category();

  // error_condition _system_error_category::default_error_condition(int ev) const
  // Is in Platform/system_error.inc
  public static /*const*/error_category /*&*/ system_category() {
    return SYSTEM_ERROR_CATEGORY;
  }
  
  public interface is_error_code_enum {
    /*uint*/int          getValue();
    error_category /*P*/ getCategory();
  }
  
    //<editor-fold defaultstate="collapsed" desc="std::errc">
  @Converted(kind = Converted.Kind.AUTO, source = "/usr/include/x86_64-linux-gnu/c++/4.8/bits/error_constants.h", line = 40,
   FQN="std::errc", NM="_ZSt4errc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType /usr/include/x86_64-linux-gnu/c++/4.8/bits/error_constants.h -nm=_ZSt4errc")
  //</editor-fold>
  public static enum /*class */errc/* : int*/ implements ErrorCodeEnumerator {
    address_family_not_supported(EAFNOSUPPORT),
    address_in_use(EADDRINUSE),
    address_not_available(EADDRNOTAVAIL),
    already_connected(EISCONN),
    argument_list_too_long(E2BIG),
    argument_out_of_domain(EDOM),
    bad_address(EFAULT),
    bad_file_descriptor(EBADF),
    bad_message(EBADMSG),

    broken_pipe(EPIPE),
    connection_aborted(ECONNABORTED),
    connection_already_in_progress(EALREADY),
    connection_refused(ECONNREFUSED),
    connection_reset(ECONNRESET),
    cross_device_link(EXDEV),
    destination_address_required(EDESTADDRREQ),
    device_or_resource_busy(EBUSY),
    directory_not_empty(ENOTEMPTY),
    executable_format_error(ENOEXEC),
    file_exists(EEXIST),
    file_too_large(EFBIG),
    filename_too_long(ENAMETOOLONG),
    function_not_supported(ENOSYS),
    host_unreachable(EHOSTUNREACH),
    identifier_removed(EIDRM),

    illegal_byte_sequence(EILSEQ),
    inappropriate_io_control_operation(ENOTTY),
    interrupted(EINTR),
    invalid_argument(EINVAL),
    invalid_seek(ESPIPE),
    io_error(EIO),
    is_a_directory(EISDIR),
    message_size(EMSGSIZE),
    network_down(ENETDOWN),
    network_reset(ENETRESET),
    network_unreachable(ENETUNREACH),
    no_buffer_space(ENOBUFS),
    no_child_process(ECHILD),
    no_link(ENOLINK),

    no_lock_available(ENOLCK),
    no_message_available(ENODATA),

    no_message(ENOMSG),
    no_protocol_option(ENOPROTOOPT),
    no_space_on_device(ENOSPC),
    no_stream_resources(ENOSR),

    no_such_device_or_address(ENXIO),
    no_such_device(ENODEV),
    no_such_file_or_directory(ENOENT),
    no_such_process(ESRCH),
    not_a_directory(ENOTDIR),
    not_a_socket(ENOTSOCK),
    not_a_stream(ENOSTR),

    not_connected(ENOTCONN),
    not_enough_memory(ENOMEM),
    not_supported(ENOTSUP),
    operation_canceled(ECANCELED),

    operation_in_progress(EINPROGRESS),
    operation_not_permitted(EPERM),
    operation_not_supported(EOPNOTSUPP),
    operation_would_block(EWOULDBLOCK),
    owner_dead(EOWNERDEAD),

    permission_denied(EACCES),
    protocol_error(EPROTO),

    protocol_not_supported(EPROTONOSUPPORT),
    read_only_file_system(EROFS),
    resource_deadlock_would_occur(EDEADLK),
    resource_unavailable_try_again(EAGAIN),
    result_out_of_range(ERANGE),
    state_not_recoverable(ENOTRECOVERABLE),
    stream_timeout(ETIME),
    text_file_busy(ETXTBSY),

    timed_out(ETIMEDOUT),
    too_many_files_open_in_system(ENFILE),
    too_many_files_open(EMFILE),
    too_many_links(EMLINK),
    too_many_symbolic_link_levels(ELOOP),
    value_too_large(EOVERFLOW),

    wrong_protocol_type(EPROTOTYPE);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static errc valueOf(int val) {
      errc out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    @Override
    public error_code make_error_code() {
      return new error_code(value, generic_category());
    }

    private static final class Values {
      private static final errc[] VALUES;
      private static final errc[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (errc kind : errc.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new errc[min < 0 ? (1-min) : 0];
        VALUES = new errc[max >= 0 ? (1+max) : 0];
        for (errc kind : errc.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private errc(/*uint*/int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  }
  
  // 19.4.3.6 non-member functions
  public static error_condition make_error_condition(errc __e){
    return new error_condition(__e.getValue(), generic_category()); 
  }

  public static /*inline*/ boolean $eq_error_code_error_condition(/*const*/error_code /*&*/ _x, /*const*/error_condition /*&*/ _y) {
    return _x.category().equivalent(_x.value(), _y) || _y.category().equivalent(_x, _y.value());
  }
  
  public static boolean $eq_error_condition(error_condition __lhs, error_condition __rhs){
    return ($eq(__lhs.category(), __rhs.category()) && $eq(__lhs.value(), __rhs.value())) ;
  }
  
  public static /*inline*/ boolean $noteq_error_code(/*const*/error_code /*&*/ _x, /*const*/error_code /*&*/ _y) {
    return !($eq_error_code$C(_x, _y));
  }
  public static /*inline*/ boolean $noteq_error_code$C(/*const*/error_code /*&*/ _x, /*const*/error_code /*&*/ _y) {
    return !($eq_error_code$C(_x, _y));
  }
  
  public static /*inline*/ boolean $eq_error_code$C(/*const*/error_code /*&*/ _x, /*const*/error_code /*&*/ _y) {
    return _x.category().$eq(_y.category()) && _x.value() == _y.value();
  }
  
  public static /*inline*/ boolean $eq_error_code(/*const*/error_code /*&*/ _x, /*const*/error_code /*&*/ _y) {
    return $eq_error_code$C(_x, _y);
  }
  
  /// error_condition
  // Portable error identification
  public static class error_condition {
    private int _val_;
    private /*const*/error_category /*P*/ _cat_;
  /*public:*/
    
    public error_condition() {
      /* : _val_(0), _cat_(&generic_category())*/ 
      //START JInit
      this._val_ = 0;
      this._cat_ = /*AddrOf*/generic_category();
      //END JInit
    }

    public error_condition(int _val, /*const*/error_category /*&*/ _cat) {
      /* : _val_(_val), _cat_(&_cat)*/ 
      //START JInit
      this._val_ = _val;
      this._cat_ = /*AddrOf*/_cat;
      //END JInit
    }

    /*template <class E> TEMPLATE*/
    public error_condition(errc _e) {
      this.$assign(make_error_condition(_e));
    }

//    /*template <class E> TEMPLATE*/
//    public error_condition(errc._ _e) {
//      this.$assign(make_error_condition(_e));
//    }

    public void assign(int _val, /*const*/error_category /*&*/ _cat) {
      _val_ = _val;
      _cat_ = /*AddrOf*/_cat;
    }

    /*template <class E> TEMPLATE*/
    public error_condition $assign(errc _e) {
      this.$assign(make_error_condition(_e));
      return /*Deref*/this;
    }
//    public error_condition $assign(errc._ _e) {
//      this.$assign(llvm.make_error_condition(_e));
//      return /*Deref*/this;
//    }  
    public error_condition $assign(error_condition _e) {
      this.assign(_e._val_, _e._cat_);
      return /*Deref*/this;
    }

    public void clear() {
      _val_ = 0;
      _cat_ = /*AddrOf*/generic_category();
    }

    public int value() /*const*/ {
      return _val_;
    }

    public /*const*/error_category /*&*/ category() /*const*/ {
      return /*Deref*/_cat_;
    }


    // error_condition
    public std.string message() /*const*/ {
      return _cat_.message(_val_);
    }

    /*typedef void (*unspecified_bool_type)() __attribute__((cdecl))*/;
    public static void unspecified_bool_true() {
    }

    // true if error
    public Object $Void2Void()/* __attribute__((cdecl))*/ {
      return _val_ == 0 ? null : unspecified_bool_true;
    }

    public /*inline*/ error_condition(/*const*/error_condition /*&*/ $Prm0)/* throw()*/ {
      /* : _val_(._val_), _cat_(._cat_)*/ 
      //START JInit
      this._val_ = $Prm0._val_;
      this._cat_ = $Prm0._cat_;
      //END JInit
    }

    @Override
    public String toString() {
      return "error_code{" + message() + ", _val_=" + _val_ + ", _cat_=" + _cat_.name() + '}';
    } 

  }
  
  /// error_category
  public static abstract class error_category implements Destructors.ClassWithDestructor, Native.NativeComparable<error_category> {
  /*public:*/
    public void $destroy() {
    }

  /*private:*/

    // class error_category
    protected error_category() {
    }

    private error_category(/*const*/error_category /*&*/ $Prm0) {
      throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");
    }

    private error_category /*&*/ $assign(/*const*/error_category /*&*/ $Prm0) {
      throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");
    }

  /*public:*/
    public abstract /*virtual*/ /*const*/CharSequence/*char P*/ name() /*const*//* = 0*/;

    public error_condition default_error_condition(int ev) /*const*/ {
      return new error_condition(ev, /*Deref*/this);
    }

    public boolean equivalent(int code, /*const*/error_condition /*&*/ condition) /*const*/ {
      return $eq_error_condition(default_error_condition(code), condition);
    }

    public boolean equivalent(/*const*/error_code /*&*/ code, int condition) /*const*/ {
      return /*Deref*/this.$eq(code.category()) && code.value() == condition;
    }

    public abstract /*virtual*/ std.string message(int _ev) /*const*//* = 0*/;

    public boolean $eq(/*const*/error_category /*&*/ _rhs) /*const*/ {
      return this == /*AddrOf*/_rhs;
    }

    public boolean $noteq(/*const*/error_category /*&*/ _rhs) /*const*/ {
      return !(/*Deref*/this.$eq(_rhs));
    }

    public boolean $less(/*const*/error_category /*&*/ _rhs) /*const*/ {
  //    return this < /*AddrOf*/_rhs;
      // FIXME: compare names
      return std.strcmp(this.name(), _rhs.name()) < 0;
    }


    /*friend  class _do_message*/;

    @Override
    public String toString() {
      return "" + name();
    }
  }
  
  public static class error_code implements is_error_code_enum, Native.Native$Bool, Native.NativeComparable<Object> {
    private int _val_;
    private /*const*/error_category /*P*/ _cat_;
  /*public:*/
    public error_code() {
      /* : _val_(0), _cat_(&system_category())*/ 
      //START JInit
      this._val_ = 0;
      this._cat_ = /*AddrOf*/system_category();
      //END JInit
    }

    public static error_code success() {
      return new error_code();
    }

    public error_code(int _val, /*const*/error_category /*&*/ _cat) {
      /* : _val_(_val), _cat_(&_cat)*/ 
      //START JInit
      this._val_ = _val;
      this._cat_ = /*AddrOf*/_cat;
      //END JInit
    }

    public error_code(errc err) {
      this._val_ = err.value;
      this._cat_ = generic_category();
    }
    
    public error_code(is_error_code_enum err) {
      this._val_ = err.getValue();
      this._cat_ = err.getCategory();
    }
//  //  /*template <class E> TEMPLATE*/
//    public error_code(windows_error _e) {
//      this(make_error_code(_e));
//    }
//    public error_code(windows_error._ _e) {
//      this(make_error_code(_e));
//    }
//  //  public </*class*/ E> error_code(E _e,  enable_if_c<is_error_code_enum<E>.value>.type /*P*/ $Prm1/*= 0*/) {
//  //    this.$set(make_error_code(_e));
//  //  }

    public error_code(JavaDifferentiators.JD$Move INSTANCE, error_code EC) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void assign(int _val, /*const*/error_category /*&*/ _cat) {
      _val_ = _val;
      _cat_ = /*AddrOf*/_cat;
    }

//    //  /*template <class E> TEMPLATE*/
//    public error_code $assign(windows_error _e) {
//      return $assign(llvm.make_error_code(_e));
//    }
//    public error_code $assign(windows_error._ _e) {
//      return $assign(llvm.make_error_code(_e));
//    }
    public /*inline*/ error_code $assign(/*const*/error_code /*&*/ $Prm0)/* throw()*/ {
      this._val_ = $Prm0._val_;
      this._cat_ = $Prm0._cat_;
      return this;
    }  
    public /*inline*/ error_code $assignMove(/*const*/error_code /*&*/ $Prm0)/* throw()*/ {
      this._val_ = $Prm0._val_;
      this._cat_ = $Prm0._cat_;
      return this;
    }  
    
    public boolean $bool() {
      return _val_ != 0;
    }

    public void clear() {
      _val_ = 0;
      _cat_ = /*AddrOf*/system_category();
    }

    public int value() /*const*/ {
      return _val_;
    }

    public /*const*/error_category /*&*/ category() /*const*/ {
      return /*Deref*/_cat_;
    }

    public error_condition default_error_condition() /*const*/ {
      return _cat_.default_error_condition(_val_);
    }


    // error_code
    public std.string message() /*const*/ {
      return _cat_.message(_val_);
    }

    /*typedef void (*unspecified_bool_type)() __attribute__((cdecl))*/;
    public static void unspecified_bool_true() {
    }

    // true if error
    public Object $Void2Void() {
      return _val_ == 0 ? null : unspecified_bool_true;
    }

    public /*inline*/ error_code(/*const*/error_code /*&*/ $Prm0)/* throw()*/ {
      /* : _val_(._val_), _cat_(._cat_)*/ 
      //START JInit
      this._val_ = $Prm0._val_;
      this._cat_ = $Prm0._cat_;
      //END JInit
    }

    @Override
    public String toString() {
      if (_val_ == 0 && _cat_ == system_category()) {
        return "<SUCCESS>";
      }
      return "error_code{" + message() + ", _val_=" + _val_ + ", _cat_=" + _cat_.name() + '}';
    } 

    @Override
    public int getValue() {
      return _val_;
    }

    @Override
    public error_category getCategory() {
      return _cat_;
    }

    @Override
    public boolean $eq(Object other) {
      if (other instanceof is_error_code_enum) {
        return getValue() == ((is_error_code_enum)other).getValue() && getCategory() == ((is_error_code_enum)other).getCategory();
      } else if (other instanceof errc) {
        return getValue() == ((errc)other).value;
      }
      return false;
    }
  }
 
  /**
   * Every error_code enum should implement this interface.
   * Use every time std::is_error_code_enum in native code is specialized.
   */
  public interface ErrorCodeEnumerator {
    /**
     * Converts user`s error code to std::error_code.
     * See make_error_code functions in native code.
     * @return converted code.
     */
    error_code make_error_code();
  }
  
/**
   * Every error condition enum should implement this interface.
   * Use every time std::is_error_condition_enum in native code is specialized.
   */
  public interface ErrorConditionEnumerator {
    /**
     * Converts user`s error code to std::error_code.
     * See make_error_code functions in native code.
     * @return converted code.
     */
    error_code make_error_code();
  }
  
    /**
   * The strerror() function returns a string describing the error code passed
   * in the argument errnum, possibly using the LC_MESSAGES part of the current
   * locale to select the appropriate language. This string must not be modified
   * by the application, but may be modified by a subsequent call to perror() or
   * strerror(). No library function will modify this string.
   *
   *
   * @param errnum
   * @param buf
   * @param bufSize
   * @return The strerror() function returns the appropriate error description
   * string, or an unknown error message if the error code is unknown. The value
   * of errno is not changed for a successful call, and is set to a nonzero
   * value upon error. The strerror_r() function returns 0 on success and -1 on
   * failure, setting errno.
   */
  public static int strerror_r(int errnum, char$ptr buf, /*size_t*/int bufSize) {
    CharSequence errorStr = strerror_r_impl(errnum);
    if (errorStr == null) {
      // FIXME: what is the correct errno to set?
      setErrno(EINVAL);
      return -1;
    }
    /*uint*/int end = min(bufSize, errorStr.length());
    buf = $tryClone(buf);
    for (int i = 0; i < end; i++) {
      buf.$set(i, (byte) errorStr.charAt(i));
    }
    return 0;
  }

  private static CharSequence strerror_r_impl(int num) {
    switch (num) {
      case EPERM: return "Not owner";
      case ENOENT: return "No such file or directory";
      case ESRCH: return "No such process";
      case EINTR: return "Interrupted system call";
      case EIO: return "I/O error";
      case ENXIO: return "No such device or address";
      case E2BIG: return "Arg list too long";
      case ENOEXEC: return "Exec format error";
      case EBADF: return "Bad file number";
      case ECHILD: return "No child processes";
      case EAGAIN: return "Resource temporarily unavailable";
      case ENOMEM: return "Not enough space";
      case EACCES: return "Permission denied";
      case EFAULT: return "Bad address";
      case ENOTBLK: return "Block device required";
      case EBUSY: return "Device busy";
      case EEXIST: return "File exists";
      case EXDEV: return "Cross-device link";
      case ENODEV: return "No such device";
      case ENOTDIR: return "Not a directory";
      case EISDIR: return "Is a directory";
      case EINVAL: return "Invalid argument";
      case ENFILE: return "File table overflow";
      case EMFILE: return "Too many open files";
      case ENOTTY: return "Inappropriate ioctl for device";
      case ETXTBSY: return "Text file busy";
      case EFBIG: return "File too large";
      case ENOSPC: return "No space left on device";
      case ESPIPE: return "Illegal seek";
      case EROFS: return "Read-only file system";
      case EMLINK: return "Too many links";
      case EPIPE: return "Broken pipe";
      case EDOM: return "Argument out of domain";
      case ERANGE: return "Result too large";
      case ENOMSG: return "No message of desired type";
      case EIDRM: return "Identifier removed";
      case ECHRNG: return "Channel number out of range";
      case EL2NSYNC: return "Level 2 not synchronized";
      case EL3HLT: return "Level 3 halted";
      case EL3RST: return "Level 3 reset";
      case ELNRNG: return "Link number out of range";
      case EUNATCH: return "Protocol driver not attached";
      case ENOCSI: return "No CSI structure available";
      case EL2HLT: return "Level 2 halted";
      case EDEADLK: return "Deadlock situation detected/avoided";
      case ENOLCK: return "No record locks available";
      case ECANCELED: return "Operation canceled";
      case ENOTSUP: return "Operation not supported";
      case EDQUOT: return "Disc quota exceeded";
      case EBADE: return "Checksum failure";
      case EBADR: return "Too fragmented";
      case EXFULL: return "Message tables full";
      case ENOANO: return "Cryptographic key not available";
      case EBADRQC: return "Bad request code";
      case EBADSLT: return "Invalid slot";
      case EDEADLOCK: return "File locking deadlock";
      case EBFONT: return "Bad font file format";
      case EOWNERDEAD: return "Owner of the lock died";
      case ENOTRECOVERABLE: return "Lock is not recoverable";
      case ENOSTR: return "Not a stream device";
      case ENODATA: return "No data available";
      case ETIME: return "Timer expired";
      case ENOSR: return "Out of stream resources";
      case ENONET: return "Machine is not on the network";
      case ENOPKG: return "Package not installed";
      case EREMOTE: return "Object is remote";
      case ENOLINK: return "Link has been severed";
      case EADV: return "Advertise error";
      case ESRMNT: return "Srmount error";
      case ECOMM: return "Communication error on send";
      case EPROTO: return "Protocol error";
      case ELOCKUNMAPPED: return "Locked lock was unmapped ";
      case ENOTACTIVE: return "Facility is not active";
      case EMULTIHOP: return "Multihop attempted";
      //case EADI: return "Application Data Integrity mismatch detected";
      case EBADMSG: return "Not a data message";
      case ENAMETOOLONG: return "File name too long";
      case EOVERFLOW: return "Value too large for defined data type";
      case ENOTUNIQ: return "Name not unique on network";
      case EBADFD: return "File descriptor in bad state";
      case EREMCHG: return "Remote address changed";
      case ELIBACC: return "Can not access a needed shared library";
      case ELIBBAD: return "Accessing a corrupted shared library";
      case ELIBSCN: return ".lib section in a.out corrupted";
      case ELIBMAX: return "Attempting to link in more shared libraries than system limit";
      case ELIBEXEC: return "Can not exec a shared library directly";
      case EILSEQ: return "Illegal byte sequence";
      case ENOSYS: return "Operation not applicable";
      case ELOOP: return "Number of symbolic links encountered during path name traversal exceeds MAXSYMLINKS";
      case ERESTART: return "Error 91";
      case ESTRPIPE: return "Error 92";
      case ENOTEMPTY: return "Directory not empty";
      case EUSERS: return "Too many users";
      case ENOTSOCK: return "Socket operation on non-socket";
      case EDESTADDRREQ: return "Destination address required";
      case EMSGSIZE: return "Message too long";
      case EPROTOTYPE: return "Protocol wrong type for socket";
      case ENOPROTOOPT: return "Option not supported by protocol";
      case EPROTONOSUPPORT: return "Protocol not supported";
      case ESOCKTNOSUPPORT: return "Socket type not supported";
      case EOPNOTSUPP: return "Operation not supported on transport endpoint";
      case EPFNOSUPPORT: return "Protocol family not supported";
      case EAFNOSUPPORT: return "Address family not supported by protocol family";
      case EADDRINUSE: return "Address already in use";
      case EADDRNOTAVAIL: return "Cannot assign requested address";
      case ENETDOWN: return "Network is down";
      case ENETUNREACH: return "Network is unreachable";
      case ENETRESET: return "Network dropped connection because of reset";
      case ECONNABORTED: return "Software caused connection abort";
      case ECONNRESET: return "Connection reset by peer";
      case ENOBUFS: return "No buffer space available";
      case EISCONN: return "Transport endpoint is already connected";
      case ENOTCONN: return "Transport endpoint is not connected";
      case ESHUTDOWN: return "Cannot send after socket shutdown";
      case ETOOMANYREFS: return "Too many references: cannot splice";
      case ETIMEDOUT: return "Connection timed out";
      case ECONNREFUSED: return "Connection refused";
      case EHOSTDOWN: return "Host is down";
      case EHOSTUNREACH: return "No route to host";
      case EALREADY: return "Operation already in progress";
      case EINPROGRESS: return "Operation now in progress";
      case ESTALE: return "Stale NFS file handle";

      default:
        throw new IllegalArgumentException("Unknown error num " + num);
    }
  }
  
  /* Return a string describing the meaning of the `errno' code in ERRNUM.  */
  public static char$ptr strerror(int errnum) {
    if (errnum == 0) {
      return std.string.EMPTY.c_str();
    }
    /*const*/int MaxErrStrLen = 2000;
    /*char*/char$ptr buffer = create_char$ptr(new$char(2000));
    buffer.$set(0, $$TERM);
    strerror_r(errnum, buffer, MaxErrStrLen - 1);
    return buffer;
  }
  
  private static abstract class _do_message extends /*public*/ error_category implements Destructors.ClassWithDestructor {
  /*public:*/
    @Override public std.string message(int ev) /*const*/ {
      return new std.string(strerror(ev));
    }

    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    public /*inline*/ _do_message() {
      /* : error_category()*/ 
      //START JInit
      super();
      //END JInit
    }
  }  

  public static final class _generic_error_category extends /*public*/ _do_message {
  /*public:*/
    @Override public /*const*/CharSequence/*char P*/ name() /*const*/ {
      return "generic";
    }

    @Override public std.string message(int ev) /*const*/ {
      // ELAST
      return super.message(ev);
    }

    public /*inline*/ _generic_error_category() {
      /* : _do_message()*/ 
      //START JInit
      super();
      //END JInit
    }
  }
  
  public static final class _system_error_category extends /*public*/ _do_message {
  /*public:*/
    @Override public /*const*/CharSequence/*char P*/ name() /*const*/ {
      return "system";
    }

    @Override public std.string message(int ev) /*const*/ {
      return super.message(ev);
    }

    @Override public error_condition default_error_condition(int ev) /*const*/ {
      // ELAST
      return new error_condition(ev, generic_category());
    }

    public /*inline*/ _system_error_category() {
      /* : _do_message()*/ 
      //START JInit
      super();
      //END JInit
    }

  }
}
