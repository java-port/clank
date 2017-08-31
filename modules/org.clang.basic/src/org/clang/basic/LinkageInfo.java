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

package org.clang.basic;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 51,
 FQN="clang::LinkageInfo", NM="_ZN5clang11LinkageInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfoE")
//</editor-fold>
public class LinkageInfo {
  private /*JBYTE uint8_t*/ Linkage linkage_ /*: 3*/;
  private /*JBYTE uint8_t*/ Visibility visibility_ /*: 2*/;
  private /*JBIT uint8_t*/ boolean explicit_ /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::setVisibility">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 56,
   FQN="clang::LinkageInfo::setVisibility", NM="_ZN5clang11LinkageInfo13setVisibilityENS_10VisibilityEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo13setVisibilityENS_10VisibilityEb")
  //</editor-fold>
  private void setVisibility(Visibility V, boolean E) {
    visibility_ = V;
    explicit_ = E;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::LinkageInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 58,
   FQN="clang::LinkageInfo::LinkageInfo", NM="_ZN5clang11LinkageInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfoC1Ev")
  //</editor-fold>
  public LinkageInfo() {
    /* : linkage_(ExternalLinkage), visibility_(DefaultVisibility), explicit_(false)*/ 
    //START JInit
    this.linkage_ = Linkage.ExternalLinkage;
    this.visibility_ = Visibility.DefaultVisibility;
    this.explicit_ = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::LinkageInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 60,
   FQN="clang::LinkageInfo::LinkageInfo", NM="_ZN5clang11LinkageInfoC1ENS_7LinkageENS_10VisibilityEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfoC1ENS_7LinkageENS_10VisibilityEb")
  //</editor-fold>
  public LinkageInfo(Linkage L, Visibility V, boolean E) {
    /* : linkage_(L), visibility_(V), explicit_(E)*/ 
    //START JInit
    this.linkage_ = L;
    this.visibility_ = V;
    this.explicit_ = E;
    //END JInit
    assert (getLinkage() == L && getVisibility() == V && isVisibilityExplicit() == E) : "Enum truncated!";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::external">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 66,
   FQN="clang::LinkageInfo::external", NM="_ZN5clang11LinkageInfo8externalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo8externalEv")
  //</editor-fold>
  public static LinkageInfo external() {
    return new LinkageInfo();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::internal">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 69,
   FQN="clang::LinkageInfo::internal", NM="_ZN5clang11LinkageInfo8internalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo8internalEv")
  //</editor-fold>
  public static LinkageInfo internal() {
    return new LinkageInfo(Linkage.InternalLinkage, Visibility.DefaultVisibility, false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::uniqueExternal">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 72,
   FQN="clang::LinkageInfo::uniqueExternal", NM="_ZN5clang11LinkageInfo14uniqueExternalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo14uniqueExternalEv")
  //</editor-fold>
  public static LinkageInfo uniqueExternal() {
    return new LinkageInfo(Linkage.UniqueExternalLinkage, Visibility.DefaultVisibility, false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::none">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 75,
   FQN="clang::LinkageInfo::none", NM="_ZN5clang11LinkageInfo4noneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo4noneEv")
  //</editor-fold>
  public static LinkageInfo none() {
    return new LinkageInfo(Linkage.NoLinkage, Visibility.DefaultVisibility, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::getLinkage">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 79,
   FQN="clang::LinkageInfo::getLinkage", NM="_ZNK5clang11LinkageInfo10getLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11LinkageInfo10getLinkageEv")
  //</editor-fold>
  public Linkage getLinkage() /*const*/ {
    return linkage_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::getVisibility">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 80,
   FQN="clang::LinkageInfo::getVisibility", NM="_ZNK5clang11LinkageInfo13getVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11LinkageInfo13getVisibilityEv")
  //</editor-fold>
  public Visibility getVisibility() /*const*/ {
    return visibility_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::isVisibilityExplicit">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 81,
   FQN="clang::LinkageInfo::isVisibilityExplicit", NM="_ZNK5clang11LinkageInfo20isVisibilityExplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11LinkageInfo20isVisibilityExplicitEv")
  //</editor-fold>
  public boolean isVisibilityExplicit() /*const*/ {
    return explicit_;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::setLinkage">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 83,
   FQN="clang::LinkageInfo::setLinkage", NM="_ZN5clang11LinkageInfo10setLinkageENS_7LinkageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo10setLinkageENS_7LinkageE")
  //</editor-fold>
  public void setLinkage(Linkage L) {
    linkage_ = L;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::mergeLinkage">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 85,
   FQN="clang::LinkageInfo::mergeLinkage", NM="_ZN5clang11LinkageInfo12mergeLinkageENS_7LinkageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo12mergeLinkageENS_7LinkageE")
  //</editor-fold>
  public void mergeLinkage(Linkage L) {
    setLinkage(minLinkage(getLinkage(), L));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::mergeLinkage">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 88,
   FQN="clang::LinkageInfo::mergeLinkage", NM="_ZN5clang11LinkageInfo12mergeLinkageES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo12mergeLinkageES0_")
  //</editor-fold>
  public void mergeLinkage(LinkageInfo other) {
    mergeLinkage(other.getLinkage());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::mergeExternalVisibility">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 92,
   FQN="clang::LinkageInfo::mergeExternalVisibility", NM="_ZN5clang11LinkageInfo23mergeExternalVisibilityENS_7LinkageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo23mergeExternalVisibilityENS_7LinkageE")
  //</editor-fold>
  public void mergeExternalVisibility(Linkage L) {
    Linkage ThisL = getLinkage();
    if (!isExternallyVisible(L)) {
      if (ThisL == Linkage.VisibleNoLinkage) {
        ThisL = Linkage.NoLinkage;
      } else if (ThisL == Linkage.ExternalLinkage) {
        ThisL = Linkage.UniqueExternalLinkage;
      }
    }
    setLinkage(ThisL);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::mergeExternalVisibility">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 102,
   FQN="clang::LinkageInfo::mergeExternalVisibility", NM="_ZN5clang11LinkageInfo23mergeExternalVisibilityES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo23mergeExternalVisibilityES0_")
  //</editor-fold>
  public void mergeExternalVisibility(LinkageInfo Other) {
    mergeExternalVisibility(Other.getLinkage());
  }

  
  /// Merge in the visibility 'newVis'.
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::mergeVisibility">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 107,
   FQN="clang::LinkageInfo::mergeVisibility", NM="_ZN5clang11LinkageInfo15mergeVisibilityENS_10VisibilityEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo15mergeVisibilityENS_10VisibilityEb")
  //</editor-fold>
  public void mergeVisibility(Visibility newVis, boolean newExplicit) {
    Visibility oldVis = getVisibility();
    
    // Never increase visibility.
    if (oldVis.getValue() < newVis.getValue()) {
      return;
    }
    
    // If the new visibility is the same as the old and the new
    // visibility isn't explicit, we have nothing to add.
    if (oldVis == newVis && !newExplicit) {
      return;
    }
    
    // Otherwise, we're either decreasing visibility or making our
    // existing visibility explicit.
    setVisibility(newVis, newExplicit);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::mergeVisibility">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 123,
   FQN="clang::LinkageInfo::mergeVisibility", NM="_ZN5clang11LinkageInfo15mergeVisibilityES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo15mergeVisibilityES0_")
  //</editor-fold>
  public void mergeVisibility(LinkageInfo other) {
    mergeVisibility(other.getVisibility(), other.isVisibilityExplicit());
  }

  
  /// Merge both linkage and visibility.
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::merge">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 128,
   FQN="clang::LinkageInfo::merge", NM="_ZN5clang11LinkageInfo5mergeES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo5mergeES0_")
  //</editor-fold>
  public void merge(LinkageInfo other) {
    mergeLinkage(other);
    mergeVisibility(other);
  }

  
  /// Merge linkage and conditionally merge visibility.
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::mergeMaybeWithVisibility">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 134,
   FQN="clang::LinkageInfo::mergeMaybeWithVisibility", NM="_ZN5clang11LinkageInfo24mergeMaybeWithVisibilityES0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfo24mergeMaybeWithVisibilityES0_b")
  //</editor-fold>
  public void mergeMaybeWithVisibility(LinkageInfo other, boolean withVis) {
    mergeLinkage(other);
    if (withVis) {
      mergeVisibility(other);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::LinkageInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 51,
   FQN="clang::LinkageInfo::LinkageInfo", NM="_ZN5clang11LinkageInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ LinkageInfo(/*const*/ LinkageInfo /*&*/ $Prm0) {
    /* : linkage_(.linkage_), visibility_(.visibility_), explicit_(.explicit_)*/ 
    //START JInit
    this.linkage_ = $Prm0.linkage_;
    this.visibility_ = $Prm0.visibility_;
    this.explicit_ = $Prm0.explicit_;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::LinkageInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 51,
   FQN="clang::LinkageInfo::LinkageInfo", NM="_ZN5clang11LinkageInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ LinkageInfo(JD$Move _dparam, LinkageInfo /*&&*/$Prm0) {
    /* : linkage_(static_cast<LinkageInfo &&>().linkage_), visibility_(static_cast<LinkageInfo &&>().visibility_), explicit_(static_cast<LinkageInfo &&>().explicit_)*/ 
    //START JInit
    this.linkage_ = $Prm0.linkage_;
    this.visibility_ = $Prm0.visibility_;
    this.explicit_ = $Prm0.explicit_;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 51,
   FQN="clang::LinkageInfo::operator=", NM="_ZN5clang11LinkageInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11LinkageInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ LinkageInfo /*&*/ $assignMove(LinkageInfo /*&&*/$Prm0) {
    this.linkage_ = $Prm0.linkage_;
    this.visibility_ = $Prm0.visibility_;
    this.explicit_ = $Prm0.explicit_;
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "linkage_=" + linkage_ // NOI18N
              + ", visibility_=" + visibility_ // NOI18N
              + ", explicit_=" + explicit_; // NOI18N
  }
}
