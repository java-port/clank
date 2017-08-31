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
import org.llvm.support.*;

/*template <class T> TEMPLATE*/

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
/// When T is a reference type the behaivor is slightly different. The reference
/// is held in a std::reference_wrapper<std::remove_reference<T>::type>, and
/// there is special handling to make operator -> work as if T was not a
/// reference.
///
/// T cannot be a rvalue reference.
//<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 81,
 FQN = "llvm::ErrorOr", NM = "_ZN4llvm7ErrorOrE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrE")
//</editor-fold>
public class ErrorOrUInt  implements Destructors.ClassWithDestructor, Native.Native$Bool  {
  /*friend template <class OtherT> class ErrorOr*/
  
//  private static /*const*/boolean isRef = std.is_reference<T>.value;
  
  /*typedef ReferenceStorage<typename std::remove_reference<T>::type> wrap*/
//  public final class wrap extends ReferenceStorage< std.remove_reference<T>.type>{ };
/*public:*/
  /*typedef typename std::conditional<isRef, wrap, T>::type storage_type*/
//  public final class storage_type extends  std.conditional<isRef, wrap, T>.type{ };
/*private:*/
  /*typedef typename std::remove_reference<T>::type &reference*/
//  public final class reference extends  std.remove_reference<T>.type /*&*/ { };
  /*typedef const typename std::remove_reference<T>::type &const_reference*/
//  public final class const_reference extends /*const*/  std.remove_reference<T>.type /*&*/ { };
  /*typedef typename std::remove_reference<T>::type *pointer*/
//  public final class pointer extends  std.remove_reference<T>.type /*P*/ { };
/*public:*/
  /*template <class E> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 97,
   FQN = "llvm::ErrorOr::ErrorOr<T>", NM = "_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE")
  //</editor-fold>
  public ErrorOrUInt(ErrorCodeEnumerator ErrorCode) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = ErrorCode.make_error_code();
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 97,
   FQN = "llvm::ErrorOr::ErrorOr<T>", NM = "_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE")
  //</editor-fold>
  public ErrorOrUInt(ErrorConditionEnumerator ErrorCode) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = ErrorCode.make_error_code();
  }
  
/*public:*/
  /*template <class E> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 98,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE")
  //</editor-fold>
  public <T> ErrorOrUInt(JD$IsErrorCodeOrErrorCondition _dparam, errc ErrorCode) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(ErrorCode);
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 98,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ET_NSt9enable_ifIXoosr3std18is_error_code_enumIS1_EE5valuesr3std23is_error_condition_enumIS1_EE5valueEPvE4typeE")
  //</editor-fold>
  public <T> ErrorOrUInt(JD$IsErrorCodeOrErrorCondition _dparam, is_error_code_enum ErrorCode) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(ErrorCode);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 106,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 105,
   FQN = "llvm::ErrorOr::ErrorOr<T>", NM = "_ZN4llvm7ErrorOrC1ESt10error_code",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ESt10error_code")
  //</editor-fold>
  public ErrorOrUInt(std.error_code EC) {
    /* : HasError(true)*/ 
    //START JInit
    this.HasError = true;
    //END JInit
    Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(EC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 110,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 109,
   FQN = "llvm::ErrorOr::ErrorOr<T>", NM = "_ZN4llvm7ErrorOrC1ET_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ET_")
  //</editor-fold>
  public ErrorOrUInt(int Val) {
    /* : HasError(false)*/ 
    //START JInit
    this.HasError = false;
    //END JInit
//    /*FIXME:*/new /*(getStorage())*/  std.conditional<isRef, wrap, T>.type(( moveIfMoveConstructible<storage_type>(Val) ));
    Unnamed_field.TStorage = $tryMove(std.move(Val));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 113,
   FQN = "llvm::ErrorOr::ErrorOr<T>", NM = "_ZN4llvm7ErrorOrC1ERKNS_7ErrorOrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ERKNS_7ErrorOrIT_EE")
  //</editor-fold>
  public ErrorOrUInt(/*const*/ ErrorOrUInt /*&*/ Other) {
    copyConstruct(Other);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 133,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="_ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EE")
  //</editor-fold>
  public ErrorOrUInt(JD$Move _dparam, ErrorOrUInt /*&&*/Other) {
    moveConstruct(std.move(Other));
  }
  
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 119,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="_ZN4llvm7ErrorOrC1ERKNS_7ErrorOrIT_EEPNSt9enable_ifIXsr14is_convertibleIS2_T_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1ERKNS_7ErrorOrIT_EEPNSt9enable_ifIXsr14is_convertibleIS2_T_EE5valueEvE4typeE")
  //</editor-fold>
  public ErrorOrUInt(JD$Convertible _dparam, /*const*/ ErrorOrUInt /*&*/ Other) {
    copyConstruct(Other);
  }
  public ErrorOrUInt(JD$Convertible _dparam, /*const*/ int /*&*/ Val) {
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
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 149,
   FQN="llvm::ErrorOr::ErrorOr<T>", NM="_ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EEPNSt9enable_ifIXntsr3std14is_convertibleIS2_T_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrC1EONS_7ErrorOrIT_EEPNSt9enable_ifIXntsr3std14is_convertibleIS2_T_EE5valueEvE4typeE")
  //</editor-fold>
  public /*explicit*/ ErrorOrUInt(JD$NotConvertible _dparam, ErrorOrUInt /*&&*/Other) {
    moveConstruct(std.move(Other));
  }
  

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 155,
   FQN = "llvm::ErrorOr::operator=", NM = "_ZN4llvm7ErrorOraSERKNS_7ErrorOrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOraSERKNS_7ErrorOrIT_EE")
  //</editor-fold>
  public ErrorOrUInt /*&*/ $assign(/*const*/ ErrorOrUInt /*&*/ Other) {
    copyAssign(Other);
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 161,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 160,
   FQN="llvm::ErrorOr::operator=", NM="_ZN4llvm7ErrorOraSEONS_7ErrorOrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOraSEONS_7ErrorOrIT_EE")
  //</editor-fold>
  public ErrorOrUInt /*&*/ $assignMove(ErrorOrUInt /*&&*/Other) {
    moveAssign(std.move(Other));
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::~ErrorOr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 165,
   FQN = "llvm::ErrorOr::~ErrorOr<T>", NM = "_ZN4llvm7ErrorOrD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!HasError) {
      Destructors.$destroy(Unnamed_field.TStorage);
    }
  }

  
  /// \brief Return false if there is an error.
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator bool">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 171,
   FQN = "llvm::ErrorOr::operator bool", NM = "_ZNK4llvm7ErrorOrcvbEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK4llvm7ErrorOrcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return !HasError;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::get">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 175,
   FQN = "llvm::ErrorOr::get", NM = "_ZN4llvm7ErrorOr3getEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr3getEv")
  //</editor-fold>
  public int /*&*/ get() {
    return getStorage();
  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::get">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 176,
//   FQN="llvm::ErrorOr::get", NM="_ZNK4llvm7ErrorOr3getEv",
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK4llvm7ErrorOr3getEv")
//  //</editor-fold>
//  public /*const*/  std.remove_reference<T>.type /*&*/ get() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getError">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 178,
   FQN = "llvm::ErrorOr::getError", NM = "_ZNK4llvm7ErrorOr8getErrorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK4llvm7ErrorOr8getErrorEv")
  //</editor-fold>
  public std.error_code getError() /*const*/ {
    return HasError ? (getErrorStorage()) : new std.error_code();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator->">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 183,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 182,
   FQN = "llvm::ErrorOr::operator->", NM = "_ZN4llvm7ErrorOrptEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrptEv")
  //</editor-fold>
  public  int /*P*/ $arrow() {
    return toPointer(getStorage());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::operator*">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 189,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 186,
   FQN = "llvm::ErrorOr::operator*", NM = "_ZN4llvm7ErrorOrdeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrdeEv")
  //</editor-fold>
  public int /*&*/ $star() {
    return getStorage();
  }

/*private:*/
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::copyConstruct">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 192,
   FQN = "llvm::ErrorOr::copyConstruct", NM = "_ZN4llvm7ErrorOr13copyConstructERKNS_7ErrorOrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr13copyConstructERKNS_7ErrorOrIT_EE")
  //</editor-fold>
  private void copyConstruct(/*const*/ ErrorOrUInt /*&*/ Other) {
    if (!Other.HasError) {
      // Get the other value.
      HasError = false;
      Unnamed_field.TStorage = (Other.getStorage());
    } else {
      // Get other's error.
      HasError = true;
      Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(( Other.getError() ));
    }
  }

  
//  /*template <class T1> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::compareThisIfSameType">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 205,
//   FQN="llvm::ErrorOr::compareThisIfSameType", NM="_ZN4llvm7ErrorOr21compareThisIfSameTypeERKT_S3_",
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr21compareThisIfSameTypeERKT_S3_")
//  //</editor-fold>
//  private static </*class*/ T1> boolean compareThisIfSameType(/*const*/ T1 /*&*/ a, /*const*/ T1 /*&*/ b) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  /*template <class T1, class T2> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::compareThisIfSameType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 210,
   FQN = "llvm::ErrorOr::compareThisIfSameType", NM = "_ZN4llvm7ErrorOr21compareThisIfSameTypeERKT_RKT0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr21compareThisIfSameTypeERKT_RKT0_")
  //</editor-fold>
  private static </*class*/ T1, /*class*/ T2> boolean compareThisIfSameType(/*const*/ T1 /*&*/ a, /*const*/ T2 /*&*/ b) {
    return a == b;
  }

  
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::copyAssign">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 215,
   FQN = "llvm::ErrorOr::copyAssign", NM = "_ZN4llvm7ErrorOr10copyAssignERKNS_7ErrorOrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr10copyAssignERKNS_7ErrorOrIT_EE")
  //</editor-fold>
  private void copyAssign(/*const*/ ErrorOrUInt /*&*/ Other) {
    if (compareThisIfSameType(this, Other)) {
      return;
    }

    copyConstruct(Other);
  }

  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::moveConstruct">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 224,
   FQN = "llvm::ErrorOr::moveConstruct", NM = "_ZN4llvm7ErrorOr13moveConstructEONS_7ErrorOrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr13moveConstructEONS_7ErrorOrIT_EE")
  //</editor-fold>
  private void moveConstruct(ErrorOrUInt /*&&*/Other) {
    if (!Other.HasError) {
      // Get the other value.
      HasError = false;
      ///*FIXME:*/new /*(getStorage())*/  std.conditional<isRef, wrap, T>.type(( std.move($star(Other.getStorage())) ));
      Unnamed_field.TStorage = ($tryMove(std.move(Other.getStorage())));
    } else {
      // Get other's error.
      HasError = true;
      Unnamed_field.ErrorStorage = /*FIXME:*/new /*(getErrorStorage())*/ std.error_code(( Other.getError() ));
    }
  }

  
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::moveAssign">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 237,
   FQN = "llvm::ErrorOr::moveAssign", NM = "_ZN4llvm7ErrorOr10moveAssignEONS_7ErrorOrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr10moveAssignEONS_7ErrorOrIT_EE")
  //</editor-fold>
  private void moveAssign(ErrorOrUInt /*&&*/Other) {
    if (compareThisIfSameType(this, Other)) {
      return;
    }

    copyConstruct(Other);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::toPointer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 250,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 245,
   FQN = "llvm::ErrorOr::toPointer", NM = "_ZN4llvm7ErrorOr9toPointerEPNSt16remove_referenceIT_E4typeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr9toPointerEPNSt16remove_referenceIT_E4typeE")
  //</editor-fold>
  private int /*P*/ toPointer( int /*P*/ Val) {
    return Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::toPointer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 256,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 249,
   FQN = "llvm::ErrorOr::toPointer", NM = "_ZN4llvm7ErrorOr9toPointerEPNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr9toPointerEPNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE")
  //</editor-fold>
  private int /*P*/ toPointer(ReferenceStorage<Integer> /*P*/ Val) {
    return $AddrOf(Val.get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getStorage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 262,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 253,
   FQN = "llvm::ErrorOr::getStorage", NM = "_ZN4llvm7ErrorOr10getStorageEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr10getStorageEv")
  //</editor-fold>
  private int /*P*/ getStorage() {
    return Unnamed_field.TStorage;
  }

  
  ////<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getStorage">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 258,
//   FQN="llvm::ErrorOr::getStorage", NM="_ZNK4llvm7ErrorOr10getStorageEv",
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK4llvm7ErrorOr10getStorageEv")
//  //</editor-fold>
//  private /*const*/  std.conditional<isRef, wrap, T>.type /*P*/ getStorage() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getErrorStorage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 272,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 263,
   FQN = "llvm::ErrorOr::getErrorStorage", NM = "_ZN4llvm7ErrorOr15getErrorStorageEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOr15getErrorStorageEv")
  //</editor-fold>
  private std.error_code /*P*/ getErrorStorage() {
    assert HasError :"Cannot get error when a value exists!";
    return Unnamed_field.ErrorStorage;
  }

  
  ////<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::getErrorStorage">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 268,
//   FQN="llvm::ErrorOr::getErrorStorage", NM="_ZNK4llvm7ErrorOr15getErrorStorageEv",
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK4llvm7ErrorOr15getErrorStorageEv")
//  //</editor-fold>
//  private /*const*/ error_code /*P*/ getErrorStorage() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorOr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 282,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 273,
   FQN = "llvm::ErrorOr::(anonymous)", NM = "_ZN4llvm7ErrorOrE_Unnamed_union1",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN4llvm7ErrorOrE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public int TStorage;
    public std.error_code ErrorStorage;
    
    public String toString() {
      return "" + "TStorage=" + TStorage // NOI18N
                + ", ErrorStorage=" + ErrorStorage; // NOI18N
    }
  };
  private Unnamed_union1 Unnamed_field = new Unnamed_union1();
  private /*JBIT bool*/ boolean HasError /*: 1*/;
  
  public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field // NOI18N
              + ", HasError=" + HasError; // NOI18N
  }
}
