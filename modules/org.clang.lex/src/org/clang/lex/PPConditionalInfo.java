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

package org.clang.lex;

import org.clank.support.*;
import static org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;


/// \brief Information about the conditional stack (\#if directives)
/// currently active.
//<editor-fold defaultstate="collapsed" desc="clang::PPConditionalInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 305,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 304,
 FQN="clang::PPConditionalInfo", NM="_ZN5clang17PPConditionalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang17PPConditionalInfoE")
//</editor-fold>
public final class/*struct*/ PPConditionalInfo implements Native.NativePOD<PPConditionalInfo> {
  // constant to be used as defaultValue in other collections.
  // tihs instance is cloned, but have not be modified  
  public static final PPConditionalInfo DEFAULT = new PPConditionalInfo();
  
  /// \brief Location where the conditional started.
  private /*uint*/int IfLoc;
  
  /// \brief True if this was contained in a skipping directive, e.g.,
  /// in a "\#if 0" block.
  public boolean WasSkipping;
  
  /// \brief True if we have emitted tokens already, and now we're in
  /// an \#else block or something.  Only useful in Skipping blocks.
  public boolean FoundNonSkip;
  
  /// \brief True if we've seen a \#else in this block.  If so,
  /// \#elif/\#else directives are not allowed.
  public boolean FoundElse;
  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalInfo::PPConditionalInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 304,
   FQN="clang::PPConditionalInfo::PPConditionalInfo", NM="_ZN5clang17PPConditionalInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang17PPConditionalInfoC1Ev")
  //</editor-fold>
  public /*inline*/ PPConditionalInfo() {
    /* : IfLoc()*/ 
    //START JInit
    this.IfLoc = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalInfo::PPConditionalInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 304,
   FQN="clang::PPConditionalInfo::PPConditionalInfo", NM="_ZN5clang17PPConditionalInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang17PPConditionalInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PPConditionalInfo(/*const*/PPConditionalInfo /*&*/ $Prm0)/* throw()*/ {
    /* : IfLoc(.IfLoc), WasSkipping(.WasSkipping), FoundNonSkip(.FoundNonSkip), FoundElse(.FoundElse)*/ 
    //START JInit
    this.IfLoc = $Prm0.IfLoc;
    this.WasSkipping = $Prm0.WasSkipping;
    this.FoundNonSkip = $Prm0.FoundNonSkip;
    this.FoundElse = $Prm0.FoundElse;
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalInfo::PPConditionalInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 304,
   FQN="clang::PPConditionalInfo::PPConditionalInfo", NM="_ZN5clang17PPConditionalInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang17PPConditionalInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ PPConditionalInfo(JD$Move _dparam, PPConditionalInfo /*&&*/$Prm0) {
    /* : IfLoc(static_cast<PPConditionalInfo &&>().IfLoc), WasSkipping(static_cast<PPConditionalInfo &&>().WasSkipping), FoundNonSkip(static_cast<PPConditionalInfo &&>().FoundNonSkip), FoundElse(static_cast<PPConditionalInfo &&>().FoundElse)*/ 
    //START JInit
    this.IfLoc = $Prm0.IfLoc;
    this.WasSkipping = $Prm0.WasSkipping;
    this.FoundNonSkip = $Prm0.FoundNonSkip;
    this.FoundElse = $Prm0.FoundElse;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 304,
   FQN="clang::PPConditionalInfo::operator=", NM="_ZN5clang17PPConditionalInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang17PPConditionalInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ PPConditionalInfo /*&*/ $assign(/*const*/PPConditionalInfo /*&*/ $Prm0)/* throw()*/ {
    this.IfLoc = $Prm0.IfLoc;
    this.WasSkipping = $Prm0.WasSkipping;
    this.FoundNonSkip = $Prm0.FoundNonSkip;
    this.FoundElse = $Prm0.FoundElse;
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 304,
   FQN="clang::PPConditionalInfo::operator=", NM="_ZN5clang17PPConditionalInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang17PPConditionalInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ PPConditionalInfo /*&*/ $assignMove(PPConditionalInfo /*&&*/$Prm0) {
    this.IfLoc = $Prm0.IfLoc;
    this.WasSkipping = $Prm0.WasSkipping;
    this.FoundNonSkip = $Prm0.FoundNonSkip;
    this.FoundElse = $Prm0.FoundElse;
    return /*Deref*/this;
  }


  @Override
  public PPConditionalInfo clone() {
    return new PPConditionalInfo(this);
  }

  @Override
  public String toString() {
    return "PPConditionalInfo{" + "IfLoc=" + getIfLoc() + ", WasSkipping=" + WasSkipping + ", FoundNonSkip=" + FoundNonSkip + ", FoundElse=" + FoundElse + '}';
  }

  @Override
  public boolean $noteq(PPConditionalInfo other) {
    return !$eq(other);
  }

  @Override
  public boolean $eq(PPConditionalInfo obj) {
    final PPConditionalInfo other = (PPConditionalInfo) obj;
    if (this.WasSkipping != other.WasSkipping) {
      return false;
    }
    if (this.FoundNonSkip != other.FoundNonSkip) {
      return false;
    }
    if (this.FoundElse != other.FoundElse) {
      return false;
    }
    return this.IfLoc == other.IfLoc;
  }

  /**
   * @return the IfLoc
   */
  public /*SourceLocation*/int getIfLoc() {
    return IfLoc;
  }

  /**
   * @param IfLoc the IfLoc to set
   */
  public void setIfLoc(SourceLocation IfLoc) {
    this.IfLoc = IfLoc.getRawEncoding();
  }
  public void setIfLoc(/*SourceLocation*/int IfLoc) {
    this.IfLoc = IfLoc;
  }
}
