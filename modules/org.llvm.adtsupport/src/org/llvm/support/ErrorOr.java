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

package org.llvm.support;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.support.Native.*;


/// \brief Represents either an error or a value T.
///
/// ErrorOr<T> is a pointer-like class that represents the result of an
/// operation. The result is either an error, or a value of type T. This is
/// designed to emulate the usage of returning a pointer where nullptr indicates
/// failure. However instead of just knowing that the operation failed, we also
/// have an error_code and optional user data that describes why it failed.
///
/// It is used like the following.
/// \code
///   ErrorOr<Buffer> getBuffer();
///
///   auto buffer = getBuffer();
///   if (error_code ec = buffer.getError())
///     return ec;
///   buffer->write("adena");
/// \endcode
///
///
/// Implicit conversion to bool returns true if there is a usable value. The
/// unary * and -> operators provide pointer like access to the value. Accessing
/// the value when there is an error has undefined behavior.
///
/// When T is a reference type the behavior is slightly different. The reference
/// is held in a std::reference_wrapper<std::remove_reference<T>::type>, and
/// there is special handling to make operator -> work as if T was not a
/// reference.
///
/// T cannot be a rvalue reference.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 67,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 81,
 FQN="llvm::ErrorOr", NM="_ZN4llvm7ErrorOrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOrE")
//</editor-fold>
public class ErrorOr</*class*/ T>  implements Destructors.ClassWithDestructor, Native.Native$Bool  {
  /*friend template <class OtherT> class ErrorOr*/
  // JAVA: private static /*const*/boolean isRef = std.is_reference.<T>value;
  // JAVA: typedef ReferenceStorage<typename std::remove_reference<T>::type> wrap
//  public final class wrap extends ReferenceStorage< std.remove_reference.type<T> >{ };
/*public:*/
  // JAVA: typedef typename std::conditional<isRef, wrap, T>::type storage_type
//  public final class storage_type extends ReferenceStorage<T>{ };
/*private:*/
  // JAVA: typedef typename std::remove_reference<T>::type &reference
//  public final class reference extends T /*&*/{ };
  // JAVA: typedef const typename std::remove_reference<T>::type &const_reference
//  public final class const_reference extends T /*&*/{ };
  // JAVA: typedef typename std::remove_reference<T>::type *pointer
//  public final class pointer extends T /*P*/{ };
  // JAVA: typedef const typename std::remove_reference<T>::type *const_pointer
//  public final class const_pointer extends T /*P*/{ };
/*public:*/
  /*template <class E> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 97,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="Tpl__ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE")
  //</editor-fold>
  public <T> ErrorOr(JD$IsErrorCodeOrErrorCondition _dparam, is_error_code_enum ErrorCode) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(ErrorCode);
  }  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 98,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE")
  //</editor-fold>
  public <T> ErrorOr(JD$IsErrorCodeOrErrorCondition _dparam, errc ErrorCode) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(ErrorCode);
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 92,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 106,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="_ZN4llvm7ErrorOrC1ESt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOrC1ESt10error_code")
  //</editor-fold>
  public ErrorOr(std.error_code EC) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(EC);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 97,
   FQN = "llvm::ErrorOr::ErrorOr<T>", NM = "_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE")
  //</editor-fold>
  public ErrorOr(ErrorCodeEnumerator ErrorCode) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = ErrorCode.make_error_code();
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 104,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 114,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="_ZN4llvm7ErrorOrC1ERKNS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOrC1ERKNS_7ErrorOrIT_EE")
  //</editor-fold>
  public ErrorOr(final /*const*/ ErrorOr<T> /*&*/ Other) {
    copyConstruct(Other);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 97,
   FQN = "llvm::ErrorOr::ErrorOr<T>", NM = "_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE")
  //</editor-fold>
  public ErrorOr(ErrorConditionEnumerator ErrorCode) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = ErrorCode.make_error_code();
  }
  
/*public:*/
  /*template <class E> TEMPLATE*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 110,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 109,
   FQN = "llvm::ErrorOr::ErrorOr<T>", NM = "_ZN4llvm7ErrorOrC1ET_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ET_")
  //</editor-fold>
  public ErrorOr(T Val) {
    /* : HasError(false)*/ 
    //START JInit
    this.HasError = false;
    //END JInit
//    /*FIXME:*/new /*(getStorage())*/  std.conditional<isRef, wrap, T>.type(( moveIfMoveConstructible<storage_type>(Val) ));
    Unnamed_field.TStorage = $tryMove(std.move(Val));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 124,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 134,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="_ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EE")
  //</editor-fold>
  public ErrorOr(JD$Move _dparam, final ErrorOr<T> /*&&*/Other) {
    moveConstruct(std.move(Other));
  }
  
  
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 129,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 138,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="Tpl__ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EEPNSt9enable_ifIXsr14is_convertibleIS2_T_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EEPNSt9enable_ifIXsr14is_convertibleIS2_T_EE5valueEvE4typeE")
  //</editor-fold>
  public </*class*/ OtherT> ErrorOr(JD$Convertible _dparam, final ErrorOr<OtherT> /*&&*/Other) {
    moveConstruct(std.move(Other));
  }
  public ErrorOr(JD$Convertible _dparam, /*const*/ T /*&*/ Val) {
    /* : HasError(false)*/ 
    //START JInit
    this.HasError = false;
    //END JInit
//    /*FIXME:*/new /*(getStorage())*/  std.conditional<isRef, wrap, T>.type(( moveIfMoveConstructible<storage_type>(Val) ));
    Unnamed_field.TStorage = $tryMove(std.move(Val));
  }
  
  
  // This might eventually need SFINAE but it's more complex than is_convertible
  // & I'm too lazy to write it right now.
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 139,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 148,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="Tpl__ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EEPNSt9enable_ifIXntsr3std14is_convertibleIS2_T_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EEPNSt9enable_ifIXntsr3std14is_convertibleIS2_T_EE5valueEvE4typeE")
  //</editor-fold>
  public /*explicit*/ </*class*/ OtherT> ErrorOr(JD$NotConvertible _dparam, final ErrorOr<OtherT> /*&&*/Other) {
    moveConstruct(std.move(Other));
  }
  

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 156,
   FQN="llvm::ErrorOr::operator=", NM="_ZN4llvm7ErrorOraSERKNS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOraSERKNS_7ErrorOrIT_EE")
  //</editor-fold>
  public ErrorOr<T> /*&*/ $assign(final /*const*/ ErrorOr<T> /*&*/ Other) {
    copyAssign(Other);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 151,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 161,
   FQN="llvm::ErrorOr::operator=", NM="_ZN4llvm7ErrorOraSEONS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOraSEONS_7ErrorOrIT_EE")
  //</editor-fold>
  public ErrorOr<T> /*&*/ $assignMove(final ErrorOr<T> /*&&*/Other) {
    moveAssign(std.move(Other));
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::~ErrorOr<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 166,
   FQN="llvm::ErrorOr::~ErrorOr<T>", NM="_ZN4llvm7ErrorOrD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOrD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!HasError) {
      Destructors.$destroy(Unnamed_field.TStorage);
    }
  }

  
  /// \brief Return false if there is an error.
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 172,
   FQN="llvm::ErrorOr::operator bool", NM="_ZNK4llvm7ErrorOrcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm7ErrorOrcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return !HasError;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 176,
   FQN="llvm::ErrorOr::get", NM="_ZN4llvm7ErrorOr3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOr3getEv")
  //</editor-fold>
  public T /*&*/ get() {
    return $Deref(getStorage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 167,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 177,
   FQN="llvm::ErrorOr::get", NM="_ZNK4llvm7ErrorOr3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm7ErrorOr3getEv")
  //</editor-fold>
  public T /*&*/ get$Const() /*const*/ {
    return ((/*const_cast*/ErrorOr<T> /*P*/ )(this)).get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 169,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 179,
   FQN="llvm::ErrorOr::getError", NM="_ZNK4llvm7ErrorOr8getErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm7ErrorOr8getErrorEv")
  //</editor-fold>
  public std.error_code getError() /*const*/ {
    return HasError ? $Deref(getErrorStorage()) : new std.error_code();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 173,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 183,
   FQN="llvm::ErrorOr::operator->", NM="_ZN4llvm7ErrorOrptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOrptEv")
  //</editor-fold>
  public  /*std.remove_reference.type<T>*/ T /*P*/ /*P*/ $arrow() {
    return toPointer_type$T$P$P(getStorage());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 177,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 187,
   FQN="llvm::ErrorOr::operator->", NM="_ZNK4llvm7ErrorOrptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm7ErrorOrptEv")
  //</editor-fold>
  public /*const*/  /*std.remove_reference.type<T>*/ T /*P*/ /*P*/ $arrow$Const() /*const*/ {
    return toPointer_type$T$C$P$P$Const(getStorage());
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 189,
   FQN="llvm::ErrorOr::operator*", NM="_ZN4llvm7ErrorOrdeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOrdeEv")
  //</editor-fold>
  public T /*&*/ $star() {
    return $Deref(getStorage());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 183,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 193,
   FQN="llvm::ErrorOr::operator*", NM="_ZNK4llvm7ErrorOrdeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm7ErrorOrdeEv")
  //</editor-fold>
  public T /*&*/ $star$Const() /*const*/ {
    return $Deref(getStorage());
  }

/*private:*/
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::copyConstruct">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 187,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 196,
   FQN="llvm::ErrorOr::copyConstruct", NM="Tpl__ZN4llvm7ErrorOr13copyConstructERKNS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm7ErrorOr13copyConstructERKNS_7ErrorOrIT_EE")
  //</editor-fold>
  private </*class*/ OtherT> void copyConstruct(final /*const*/ ErrorOr<OtherT> /*&*/ Other) {
    if (!Other.HasError) {
      // Get the other value.
      HasError = false;
      Unnamed_field.TStorage = (T) ($tryClone(Other.getStorage()));
    } else {
      // Get other's error.
      HasError = true;
      Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(( Other.getError() ));
    }
  }

  
  /*template <class T1> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::compareThisIfSameType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 200,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 209,
   FQN="llvm::ErrorOr::compareThisIfSameType", NM="Tpl__ZN4llvm7ErrorOr21compareThisIfSameTypeERKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm7ErrorOr21compareThisIfSameTypeERKT_S3_")
  //</editor-fold>
  private static </*class*/ T1> boolean compareThisIfSameType_T$C$R(final /*const*/ T1 /*&*/ a, final /*const*/ T1 /*&*/ b) {
    return $AddrOf(a) == $AddrOf(b);
  }

  
  /*template <class T1, class T2> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::compareThisIfSameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 205,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 214,
   FQN="llvm::ErrorOr::compareThisIfSameType", NM="Tpl__ZN4llvm7ErrorOr21compareThisIfSameTypeERKT_RKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm7ErrorOr21compareThisIfSameTypeERKT_RKT0_")
  //</editor-fold>
  private static </*class*/ T1, /*class*/ T2> boolean compareThisIfSameType_T$C$R_T1$C$R(final /*const*/ T1 /*&*/ a, final /*const*/ T2 /*&*/ b) {
    return false;
  }

  
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::copyAssign">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 210,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 219,
   FQN="llvm::ErrorOr::copyAssign", NM="Tpl__ZN4llvm7ErrorOr10copyAssignERKNS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm7ErrorOr10copyAssignERKNS_7ErrorOrIT_EE")
  //</editor-fold>
  private </*class*/ OtherT extends T> void copyAssign(final /*const*/ ErrorOr<OtherT> /*&*/ Other) {
    if (compareThisIfSameType_T$C$R(/*Deref*/this, Other)) {
      return;
    }
    $destroy();//this->~ErrorOr<T>();
    copyConstruct(Other);///*FIXME: NEW_EXPR [NoNewFun]*/this = /*new (this)*/ new ErrorOr<T>(( Other ));
  }

  
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::moveConstruct">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 219,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 228,
   FQN="llvm::ErrorOr::moveConstruct", NM="Tpl__ZN4llvm7ErrorOr13moveConstructEONS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm7ErrorOr13moveConstructEONS_7ErrorOrIT_EE")
  //</editor-fold>
  private </*class*/ OtherT> void moveConstruct(final ErrorOr<OtherT> /*&&*/Other) {
    if (!Other.HasError) {
      // Get the other value.
      HasError = false;
      ///*FIXME:*/new /*(getStorage())*/  std.conditional<isRef, wrap, T>.type(( std.move($star(Other.getStorage())) ));
      Unnamed_field.TStorage = (T) ($tryMove(std.move(Other.getStorage())));
    } else {
      // Get other's error.
      HasError = true;
      Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(( Other.getError() ));
    }
  }

  
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::moveAssign">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 232,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 241,
   FQN="llvm::ErrorOr::moveAssign", NM="Tpl__ZN4llvm7ErrorOr10moveAssignEONS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm7ErrorOr10moveAssignEONS_7ErrorOrIT_EE")
  //</editor-fold>
  private </*class*/ OtherT extends T> void moveAssign(ErrorOr<OtherT> /*&&*/Other) {
    if (compareThisIfSameType_T$C$R(this, Other)) {
      return;
    }
    $destroy();//this->~ErrorOr<T>();
    moveConstruct(Other);///*FIXME: NEW_EXPR [NoNewFun]*/this = /*new (this)*/ new ErrorOr<T>(( std.move(Other) ));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::toPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 240,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 250,
   FQN="llvm::ErrorOr::toPointer", NM="_ZN4llvm7ErrorOr9toPointerEPNSt16remove_referenceIT_E4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOr9toPointerEPNSt16remove_referenceIT_E4typeE")
  //</editor-fold>
  private  /*std.remove_reference.type<T>*/T /*P*/ /*P*/ toPointer_type$T$P$P( /*std.remove_reference.type<T>*/T /*P*/ /*P*/ Val) {
    return Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::toPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 244,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 254,
   FQN="llvm::ErrorOr::toPointer", NM="_ZNK4llvm7ErrorOr9toPointerEPKNSt16remove_referenceIT_E4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm7ErrorOr9toPointerEPKNSt16remove_referenceIT_E4typeE")
  //</editor-fold>
  private /*const*/  /*std.remove_reference.type<T>*/T /*P*/ /*P*/ toPointer_type$T$C$P$P$Const(/*const*/  /*std.remove_reference.type<T>*/T /*P*/ /*P*/ Val) /*const*/ {
    return Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::toPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 246,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 256,
   FQN="llvm::ErrorOr::toPointer", NM="_ZN4llvm7ErrorOr9toPointerEPNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOr9toPointerEPNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE")
  //</editor-fold>
  private  /*std.remove_reference.type<T>*/T /*P*/ /*P*/ toPointer_ReferenceStorage$type$P(ReferenceStorage< /*std.remove_reference.type<T>*/T > /*P*/ Val) {
    return $AddrOf(Val.get());
  }
  

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::toPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 250,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 260,
   FQN="llvm::ErrorOr::toPointer", NM="_ZNK4llvm7ErrorOr9toPointerEPKNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm7ErrorOr9toPointerEPKNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE")
  //</editor-fold>
  private /*const*/  /*std.remove_reference.type<T>*/T /*P*/ /*P*/ toPointer_ReferenceStorage$type$C$P$Const(/*const*/ ReferenceStorage< /*std.remove_reference.type<T>*/T > /*P*/ Val) /*const*/ {
    return $AddrOf(Val.get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 252,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 262,
   FQN="llvm::ErrorOr::getStorage", NM="_ZN4llvm7ErrorOr10getStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOr10getStorageEv")
  //</editor-fold>
  private /*ReferenceStorage<T>*/ T /*P*/ getStorage() {
    assert (!HasError) : "Cannot get value when an error exists!";
//    return ((ReferenceStorage<T> /*P*/)reinterpret_cast(ReferenceStorage.class, Unnamed_field.TStorage));
    return Unnamed_field.TStorage;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 257,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 267,
   FQN="llvm::ErrorOr::getStorage", NM="_ZNK4llvm7ErrorOr10getStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm7ErrorOr10getStorageEv")
  //</editor-fold>
  private /*ReferenceStorage<T>*/ T /*P*/ getStorage$Const() /*const*/ {
    assert (!HasError) : "Cannot get value when an error exists!";
//    return ((ReferenceStorage<T> /*P*/)reinterpret_cast(ReferenceStorage.class, Unnamed_field.TStorage.buffer));
    return Unnamed_field.TStorage;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getErrorStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 262,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 272,
   FQN="llvm::ErrorOr::getErrorStorage", NM="_ZN4llvm7ErrorOr15getErrorStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOr15getErrorStorageEv")
  //</editor-fold>
  private std.error_code /*P*/ getErrorStorage() {
    assert (HasError) : "Cannot get error when a value exists!";
//    return reinterpret_cast(std.error_code /*P*/ .class, Unnamed_field.ErrorStorage.buffer);
    return Unnamed_field.ErrorStorage;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getErrorStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 277,
   FQN="llvm::ErrorOr::getErrorStorage", NM="_ZNK4llvm7ErrorOr15getErrorStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm7ErrorOr15getErrorStorageEv")
  //</editor-fold>
  private /*const*/ std.error_code /*P*/ getErrorStorage$Const() /*const*/ {
    return ((/*const_cast*/ErrorOr<T> /*P*/ )(this)).getErrorStorage();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 271,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 282,
   FQN="llvm::ErrorOr::(anonymous)", NM="_ZN4llvm7ErrorOrE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ErrorOrE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1<T> {
    public /*AlignedCharArrayUnion<ReferenceStorage<T> >*/T TStorage;
    public /*AlignedCharArrayUnion1<std.error_code>*/std.error_code ErrorStorage;
    
    @Override public String toString() {
      return "" + "TStorage=" + TStorage // NOI18N
                + ", ErrorStorage=" + ErrorStorage; // NOI18N
    }
  };
  private final Unnamed_union1<T> Unnamed_field = new Unnamed_union1();
  private /*JBIT bool*/ boolean HasError /*: 1*/;
  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field // NOI18N
              + ", HasError=" + HasError; // NOI18N
  }
}
