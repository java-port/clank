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

package org.clang.format.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


/// \brief An unwrapped line is a sequence of \c Token, that we would like to
/// put on a single line if there was no column limit.
///
/// This is used as a main interface between the \c UnwrappedLineParser and the
/// \c UnwrappedLineFormatter. The key property is that changing the formatting
/// within an unwrapped line does not affect any other unwrapped lines.
//<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 36,
 FQN="clang::format::UnwrappedLine", NM="_ZN5clang6format13UnwrappedLineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format13UnwrappedLineE")
//</editor-fold>
public class/*struct*/ UnwrappedLine implements Native.NativeComparable<UnwrappedLine>, NativeMoveable<UnwrappedLine>, Native.NativePOD<UnwrappedLine>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLine::UnwrappedLine">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 216,
   FQN="clang::format::UnwrappedLine::UnwrappedLine", NM="_ZN5clang6format13UnwrappedLineC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format13UnwrappedLineC1Ev")
  //</editor-fold>
  public /*inline*/ UnwrappedLine() {
    // : Tokens(), Level(0), InPPDirective(false), MustBeDeclaration(false) 
    //START JInit
    this.Tokens = new std.list<UnwrappedLineNode>(()->new UnwrappedLineNode());
    this.Level = 0;
    this.InPPDirective = false;
    this.MustBeDeclaration = false;
    //END JInit
  }

  
  // FIXME: Don't use std::list here.
  /// \brief The \c Tokens comprising this \c UnwrappedLine.
  public final std.list<UnwrappedLineNode> Tokens;
  
  /// \brief The indent level of the \c UnwrappedLine.
  public /*uint*/int Level;
  
  /// \brief Whether this \c UnwrappedLine is part of a preprocessor directive.
  public boolean InPPDirective;
  
  public boolean MustBeDeclaration;
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLine::UnwrappedLine">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 36,
   FQN="clang::format::UnwrappedLine::UnwrappedLine", NM="_ZN5clang6format13UnwrappedLineC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format13UnwrappedLineC1EOS1_")
  //</editor-fold>
  public /*inline*/ UnwrappedLine(JD$Move _dparam, final UnwrappedLine /*&&*/$Prm0) {
    // : Tokens(static_cast<UnwrappedLine &&>().Tokens), Level(static_cast<UnwrappedLine &&>().Level), InPPDirective(static_cast<UnwrappedLine &&>().InPPDirective), MustBeDeclaration(static_cast<UnwrappedLine &&>().MustBeDeclaration) 
    //START JInit
    this.Tokens = new std.list<UnwrappedLineNode>(JD$Move.INSTANCE, $Prm0.Tokens);
    this.Level = $Prm0.Level;
    this.InPPDirective = $Prm0.InPPDirective;
    this.MustBeDeclaration = $Prm0.MustBeDeclaration;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLine::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 36,
   FQN="clang::format::UnwrappedLine::operator=", NM="_ZN5clang6format13UnwrappedLineaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format13UnwrappedLineaSEOS1_")
  //</editor-fold>
  public /*inline*/ UnwrappedLine /*&*/ $assignMove(final UnwrappedLine /*&&*/$Prm0) {
    if (this == $Prm0) {
      return this;
    }
    assert this != $Prm0;
    this.Tokens.$assignMove($Prm0.Tokens);
    this.Level = $Prm0.Level;
    this.InPPDirective = $Prm0.InPPDirective;
    this.MustBeDeclaration = $Prm0.MustBeDeclaration;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLine::UnwrappedLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 36,
   FQN="clang::format::UnwrappedLine::UnwrappedLine", NM="_ZN5clang6format13UnwrappedLineC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format13UnwrappedLineC1ERKS1_")
  //</editor-fold>
  public /*inline*/ UnwrappedLine(final /*const*/ UnwrappedLine /*&*/ $Prm0) {
    // : Tokens(.Tokens), Level(.Level), InPPDirective(.InPPDirective), MustBeDeclaration(.MustBeDeclaration) 
    //START JInit
    this.Tokens = new std.list<UnwrappedLineNode>($Prm0.Tokens);
    this.Level = $Prm0.Level;
    this.InPPDirective = $Prm0.InPPDirective;
    this.MustBeDeclaration = $Prm0.MustBeDeclaration;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLine::~UnwrappedLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 36,
   FQN="clang::format::UnwrappedLine::~UnwrappedLine", NM="_ZN5clang6format13UnwrappedLineD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format13UnwrappedLineD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Tokens.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLine::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 36,
   FQN="clang::format::UnwrappedLine::operator=", NM="_ZN5clang6format13UnwrappedLineaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format13UnwrappedLineaSERKS1_")
  //</editor-fold>
  public /*inline*/ UnwrappedLine /*&*/ $assign(final /*const*/ UnwrappedLine /*&*/ $Prm0) {
    if (this == $Prm0) {
      return this;
    }
    this.Tokens.$assign($Prm0.Tokens);
    this.Level = $Prm0.Level;
    this.InPPDirective = $Prm0.InPPDirective;
    this.MustBeDeclaration = $Prm0.MustBeDeclaration;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public org.clank.support.aliases.uint$ref Level_ref = new org.clank.support.aliases.uint$ref() {
    @Override
    public int $deref() {
      return Level;
    }
  
    @Override
    public int $set(int value) {
      Level = value;
      return Level;
    }
  };
  
  @Override
  public UnwrappedLine clone() {
    return new UnwrappedLine(this);
  }
  
  @Override
  public boolean $eq(UnwrappedLine other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (this.Level != other.Level) {
      return false;
    }
    if (this.InPPDirective != other.InPPDirective) {
      return false;
    }
    if (this.MustBeDeclaration != other.MustBeDeclaration) {
      return false;
    }
    return this.Tokens.$eq(other.Tokens);
  }

  @Override public UnwrappedLine move() {
    return new UnwrappedLine(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Tokens=" + Tokens // NOI18N
              + ", Level=" + Level // NOI18N
              + ", InPPDirective=" + InPPDirective // NOI18N
              + ", MustBeDeclaration=" + MustBeDeclaration; // NOI18N
  }
}
