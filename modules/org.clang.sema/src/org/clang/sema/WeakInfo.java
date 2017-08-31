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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief Captures information about a \#pragma weak directive.
//<editor-fold defaultstate="collapsed" desc="clang::WeakInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 25,
 FQN="clang::WeakInfo", NM="_ZN5clang8WeakInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang8WeakInfoE")
//</editor-fold>
public class WeakInfo implements NativeCloneable<WeakInfo>, Native.NativeComparable<WeakInfo> {
  private IdentifierInfo /*P*/ alias; // alias (optional)
  private SourceLocation loc; // for diagnostics
  private boolean used; // identifier later declared?
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::WeakInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 30,
   FQN="clang::WeakInfo::WeakInfo", NM="_ZN5clang8WeakInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang8WeakInfoC1Ev")
  //</editor-fold>
  public WeakInfo() {
    // : alias(null), loc(SourceLocation()), used(false) 
    //START JInit
    this.alias = null;
    this.loc = new SourceLocation();
    this.used = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::WeakInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 32,
   FQN="clang::WeakInfo::WeakInfo", NM="_ZN5clang8WeakInfoC1EPNS_14IdentifierInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang8WeakInfoC1EPNS_14IdentifierInfoENS_14SourceLocationE")
  //</editor-fold>
  public WeakInfo(IdentifierInfo /*P*/ Alias, SourceLocation Loc) {
    // : alias(Alias), loc(Loc), used(false) 
    //START JInit
    this.alias = Alias;
    this.loc = new SourceLocation(Loc);
    this.used = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::getAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 34,
   FQN="clang::WeakInfo::getAlias", NM="_ZNK5clang8WeakInfo8getAliasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZNK5clang8WeakInfo8getAliasEv")
  //</editor-fold>
  public /*inline*/ IdentifierInfo /*P*/ getAlias() /*const*/ {
    return alias;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 35,
   FQN="clang::WeakInfo::getLocation", NM="_ZNK5clang8WeakInfo11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZNK5clang8WeakInfo11getLocationEv")
  //</editor-fold>
  public /*inline*/ SourceLocation getLocation() /*const*/ {
    return new SourceLocation(loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::setUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 36,
   FQN="clang::WeakInfo::setUsed", NM="_ZN5clang8WeakInfo7setUsedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang8WeakInfo7setUsedEb")
  //</editor-fold>
  public void setUsed() {
    setUsed(true);
  }
  public void setUsed(boolean Used/*= true*/) {
    used = Used;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::getUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 37,
   FQN="clang::WeakInfo::getUsed", NM="_ZN5clang8WeakInfo7getUsedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang8WeakInfo7getUsedEv")
  //</editor-fold>
  public /*inline*/ boolean getUsed() {
    return used;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 38,
   FQN="clang::WeakInfo::operator==", NM="_ZNK5clang8WeakInfoeqES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZNK5clang8WeakInfoeqES0_")
  //</editor-fold>
  public boolean $eq(WeakInfo RHS) /*const*/ {
    return alias == RHS.getAlias() && $eq_SourceLocation$C(loc, RHS.getLocation());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 41,
   FQN="clang::WeakInfo::operator!=", NM="_ZNK5clang8WeakInfoneES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZNK5clang8WeakInfoneES0_")
  //</editor-fold>
  public boolean $noteq(WeakInfo RHS) /*const*/ {
    return !(/*Deref*/this.$eq(/*NO_COPY*/RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::WeakInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 25,
   FQN="clang::WeakInfo::WeakInfo", NM="_ZN5clang8WeakInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang8WeakInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ WeakInfo(final /*const*/ WeakInfo /*&*/ $Prm0) {
    // : alias(.alias), loc(.loc), used(.used) 
    //START JInit
    this.alias = $Prm0.alias;
    this.loc = new SourceLocation($Prm0.loc);
    this.used = $Prm0.used;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::WeakInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 25,
   FQN="clang::WeakInfo::WeakInfo", NM="_ZN5clang8WeakInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang8WeakInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ WeakInfo(JD$Move _dparam, final WeakInfo /*&&*/$Prm0) {
    // : alias(static_cast<WeakInfo &&>().alias), loc(static_cast<WeakInfo &&>().loc), used(static_cast<WeakInfo &&>().used) 
    //START JInit
    this.alias = $Prm0.alias;
    this.loc = new SourceLocation(JD$Move.INSTANCE, $Prm0.loc);
    this.used = $Prm0.used;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WeakInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Weak.h", line = 25,
   FQN="clang::WeakInfo::operator=", NM="_ZN5clang8WeakInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang8WeakInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ WeakInfo /*&*/ $assign(final /*const*/ WeakInfo /*&*/ $Prm0) {
    this.alias = $Prm0.alias;
    this.loc.$assign($Prm0.loc);
    this.used = $Prm0.used;
    return /*Deref*/this;
  }

  @Override public WeakInfo clone() { return new WeakInfo(this); }
  
  @Override public String toString() {
    return "" + "alias=" + alias // NOI18N
              + ", loc=" + loc // NOI18N
              + ", used=" + used; // NOI18N
  }
}
