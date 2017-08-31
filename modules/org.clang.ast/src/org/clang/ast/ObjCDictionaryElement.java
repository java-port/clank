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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import org.clang.basic.*;


/// \brief An element in an Objective-C dictionary literal.
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 212,
 FQN="clang::ObjCDictionaryElement", NM="_ZN5clang21ObjCDictionaryElementE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryElementE")
//</editor-fold>
public class/*struct*/ ObjCDictionaryElement implements NativeCloneable<ObjCDictionaryElement>, Destructors.ClassWithDestructor {
  /// \brief The key for the dictionary element.
  public Expr /*P*/ Key;
  
  /// \brief The value of the dictionary element.
  public Expr /*P*/ Value;
  
  /// \brief The location of the ellipsis, if this is a pack expansion.
  public final SourceLocation EllipsisLoc;
  
  /// \brief The number of elements this pack expansion will expand to, if
  /// this is a pack expansion and is known.
  public final OptionalUInt NumExpansions;
  
  /// \brief Determines whether this dictionary element is a pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryElement::isPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 227,
   FQN="clang::ObjCDictionaryElement::isPackExpansion", NM="_ZNK5clang21ObjCDictionaryElement15isPackExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang21ObjCDictionaryElement15isPackExpansionEv")
  //</editor-fold>
  public boolean isPackExpansion() /*const*/ {
    return EllipsisLoc.isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryElement::ObjCDictionaryElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 212,
   FQN="clang::ObjCDictionaryElement::ObjCDictionaryElement", NM="_ZN5clang21ObjCDictionaryElementC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryElementC1EOS0_")
  //</editor-fold>
  public /*inline*/ ObjCDictionaryElement(JD$Move _dparam, final ObjCDictionaryElement /*&&*/$Prm0) {
    // : Key(static_cast<ObjCDictionaryElement &&>().Key), Value(static_cast<ObjCDictionaryElement &&>().Value), EllipsisLoc(static_cast<ObjCDictionaryElement &&>().EllipsisLoc), NumExpansions(static_cast<ObjCDictionaryElement &&>().NumExpansions) 
    //START JInit
    this.Key = $Prm0.Key;
    this.Value = $Prm0.Value;
    this.EllipsisLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.EllipsisLoc);
    this.NumExpansions = new OptionalUInt(JD$Move.INSTANCE, $Prm0.NumExpansions);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDictionaryElement::~ObjCDictionaryElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 212,
   FQN="clang::ObjCDictionaryElement::~ObjCDictionaryElement", NM="_ZN5clang21ObjCDictionaryElementD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang21ObjCDictionaryElementD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    NumExpansions.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public ObjCDictionaryElement(Expr Key, Expr Value, SourceLocation EllipsisLoc, OptionalUInt NumExpansions) {
    this.Key = Key;
    this.Value = Value;
    this.EllipsisLoc = EllipsisLoc;
    this.NumExpansions = NumExpansions;
  }
  
  public ObjCDictionaryElement(final ObjCDictionaryElement /*&&*/$Prm0) {
    this.Key = $Prm0.Key;
    this.Value = $Prm0.Value;
    this.EllipsisLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.EllipsisLoc);
    this.NumExpansions = new OptionalUInt(JD$Move.INSTANCE, $Prm0.NumExpansions);
  }
  
  public ObjCDictionaryElement() {
    this.EllipsisLoc = new SourceLocation();
    this.NumExpansions = new OptionalUInt();
  }
  
  @Override
  public ObjCDictionaryElement clone() {
    return new ObjCDictionaryElement(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Key=" + Key // NOI18N
              + ", Value=" + Value // NOI18N
              + ", EllipsisLoc=" + EllipsisLoc // NOI18N
              + ", NumExpansions=" + NumExpansions; // NOI18N
  }
}
