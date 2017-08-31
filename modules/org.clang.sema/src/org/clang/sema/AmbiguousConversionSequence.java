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

package org.clang.sema;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;


/// Represents an ambiguous user-defined conversion sequence.
//<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 285,
 FQN="clang::AmbiguousConversionSequence", NM="_ZN5clang27AmbiguousConversionSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequenceE")
//</editor-fold>
public class/*struct*/ AmbiguousConversionSequence {
  /*typedef SmallVector<std::pair<NamedDecl *, FunctionDecl *>, 4> ConversionSet*/
//  public final class ConversionSet extends SmallVector<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >>{ };
  
  public Object/*void P*/ FromTypePtr;
  public Object/*void P*/ ToTypePtr;
  public Object /*char Buffer[sizeof(ConversionSet)];*/ Buffer = null; // TODO: shouldn't it it be just SmallVector<std.pair<NamedDecl, FunctionDecl>>
  
  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::getFromType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 292,
   FQN="clang::AmbiguousConversionSequence::getFromType", NM="_ZNK5clang27AmbiguousConversionSequence11getFromTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang27AmbiguousConversionSequence11getFromTypeEv")
  //</editor-fold>
  public QualType getFromType() /*const*/ {
    return QualType.getFromOpaquePtr(FromTypePtr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::getToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 295,
   FQN="clang::AmbiguousConversionSequence::getToType", NM="_ZNK5clang27AmbiguousConversionSequence9getToTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang27AmbiguousConversionSequence9getToTypeEv")
  //</editor-fold>
  public QualType getToType() /*const*/ {
    return QualType.getFromOpaquePtr(ToTypePtr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::setFromType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 298,
   FQN="clang::AmbiguousConversionSequence::setFromType", NM="_ZN5clang27AmbiguousConversionSequence11setFromTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequence11setFromTypeENS_8QualTypeE")
  //</editor-fold>
  public void setFromType(QualType T) {
    FromTypePtr = T.getAsOpaquePtr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::setToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 299,
   FQN="clang::AmbiguousConversionSequence::setToType", NM="_ZN5clang27AmbiguousConversionSequence9setToTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequence9setToTypeENS_8QualTypeE")
  //</editor-fold>
  public void setToType(QualType T) {
    ToTypePtr = T.getAsOpaquePtr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::conversions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 301,
   FQN="clang::AmbiguousConversionSequence::conversions", NM="_ZN5clang27AmbiguousConversionSequence11conversionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequence11conversionsEv")
  //</editor-fold>
  public SmallVector<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >> /*&*/ conversions() {
    return $Deref(((SmallVector<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >> /*P*/)reinterpret_cast(SmallVector.class, Buffer)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::conversions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 305,
   FQN="clang::AmbiguousConversionSequence::conversions", NM="_ZNK5clang27AmbiguousConversionSequence11conversionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang27AmbiguousConversionSequence11conversionsEv")
  //</editor-fold>
  public /*const*/SmallVector<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >> /*&*/ conversions$Const() /*const*/ {
    return $Deref(((/*const*/SmallVector<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >> /*P*/)reinterpret_cast(/*const*/SmallVector.class, Buffer)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::addConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 309,
   FQN="clang::AmbiguousConversionSequence::addConversion", NM="_ZN5clang27AmbiguousConversionSequence13addConversionEPNS_9NamedDeclEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequence13addConversionEPNS_9NamedDeclEPNS_12FunctionDeclE")
  //</editor-fold>
  public void addConversion(NamedDecl /*P*/ Found, FunctionDecl /*P*/ D) {
    conversions().push_back(std.make_pair_Ptr_Ptr(Found, D));
  }

  
  /*typedef ConversionSet::iterator iterator*/
//  public final class iterator extends type$ptr<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >> { };
  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 314,
   FQN="clang::AmbiguousConversionSequence::begin", NM="_ZN5clang27AmbiguousConversionSequence5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequence5beginEv")
  //</editor-fold>
  public type$ptr<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >>  begin() {
    return conversions().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 315,
   FQN="clang::AmbiguousConversionSequence::end", NM="_ZN5clang27AmbiguousConversionSequence3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequence3endEv")
  //</editor-fold>
  public type$ptr<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >>  end() {
    return conversions().end();
  }

  
  /*typedef ConversionSet::const_iterator const_iterator*/
//  public final class const_iterator extends type$ptr<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >> { };
  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 318,
   FQN="clang::AmbiguousConversionSequence::begin", NM="_ZNK5clang27AmbiguousConversionSequence5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang27AmbiguousConversionSequence5beginEv")
  //</editor-fold>
  public type$ptr<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >>  begin$Const() /*const*/ {
    return conversions$Const().begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 319,
   FQN="clang::AmbiguousConversionSequence::end", NM="_ZNK5clang27AmbiguousConversionSequence3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang27AmbiguousConversionSequence3endEv")
  //</editor-fold>
  public type$ptr<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >>  end$Const() /*const*/ {
    return conversions$Const().end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::construct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 527,
   FQN="clang::AmbiguousConversionSequence::construct", NM="_ZN5clang27AmbiguousConversionSequence9constructEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequence9constructEv")
  //</editor-fold>
  public void construct() {
    Buffer = new SmallVector<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >>(4, new std.pairPtrPtr<NamedDecl /*P*/ , FunctionDecl /*P*/ >());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::destruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 531,
   FQN="clang::AmbiguousConversionSequence::destruct", NM="_ZN5clang27AmbiguousConversionSequence8destructEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequence8destructEv")
  //</editor-fold>
  public void destruct() {
    conversions().$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AmbiguousConversionSequence::copyFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 535,
   FQN="clang::AmbiguousConversionSequence::copyFrom", NM="_ZN5clang27AmbiguousConversionSequence8copyFromERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang27AmbiguousConversionSequence8copyFromERKS0_")
  //</editor-fold>
  public void copyFrom(final /*const*/ AmbiguousConversionSequence /*&*/ O) {
    FromTypePtr = O.FromTypePtr;
    ToTypePtr = O.ToTypePtr;
    Buffer = new SmallVector<std.pair<NamedDecl /*P*/ , FunctionDecl /*P*/ >>(O.conversions$Const());
  }

  
  @Override public String toString() {
    return "" + "FromTypePtr=" + FromTypePtr // NOI18N
              + ", ToTypePtr=" + ToTypePtr // NOI18N
              + ", Buffer=" + Buffer; // NOI18N
  }
}
