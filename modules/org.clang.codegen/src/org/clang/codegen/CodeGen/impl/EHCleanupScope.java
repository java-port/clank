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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


/// A cleanup scope which generates the cleanup blocks lazily.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 233,
 FQN="clang::CodeGen::EHCleanupScope", NM="_ZN5clang7CodeGen14EHCleanupScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScopeE")
//</editor-fold>
public class EHCleanupScope extends /*public*/ EHScope implements Destructors.ClassWithDestructor {
  /// The nearest normal cleanup scope enclosing this one.
  private EHScopeStack.stable_iterator EnclosingNormal;
  
  /// The nearest EH scope enclosing this one.
  private EHScopeStack.stable_iterator EnclosingEH;
  
  /// The dual entry/exit block along the normal edge.  This is lazily
  /// created if needed before the cleanup is popped.
  private BasicBlock /*P*/ NormalBlock;
  
  /// An optional i1 variable indicating whether this cleanup has been
  /// activated yet.
  private AllocaInst /*P*/ ActiveFlag;
  
  /// Extra information required for cleanups that have resolved
  /// branches through them.  This has to be allocated on the side
  /// because everything on the cleanup stack has be trivially
  /// movable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::ExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 252,
   FQN="clang::CodeGen::EHCleanupScope::ExtInfo", NM="_ZN5clang7CodeGen14EHCleanupScope7ExtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope7ExtInfoE")
  //</editor-fold>
  private static class/*struct*/ ExtInfo implements Destructors.ClassWithDestructor {
    /// The destinations of normal branch-afters and branch-throughs.
    public SmallPtrSet<BasicBlock /*P*/ > Branches;
    
    /// Normal branch-afters.
    public SmallVector<std.pair<BasicBlock /*P*/ , ConstantInt /*P*/ >> BranchAfters;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::ExtInfo::ExtInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 252,
     FQN="clang::CodeGen::EHCleanupScope::ExtInfo::ExtInfo", NM="_ZN5clang7CodeGen14EHCleanupScope7ExtInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope7ExtInfoC1Ev")
    //</editor-fold>
    public /*inline*/ ExtInfo() {
      // : Branches(), BranchAfters() 
      //START JInit
      this.Branches = new SmallPtrSet<BasicBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
      this.BranchAfters = new SmallVector<std.pair<BasicBlock /*P*/ , ConstantInt /*P*/ >>(4, new std.pairPtrPtr<BasicBlock /*P*/ , ConstantInt /*P*/ >());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::ExtInfo::~ExtInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 252,
     FQN="clang::CodeGen::EHCleanupScope::ExtInfo::~ExtInfo", NM="_ZN5clang7CodeGen14EHCleanupScope7ExtInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope7ExtInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      BranchAfters.$destroy();
      Branches.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Branches=" + Branches // NOI18N
                + ", BranchAfters=" + BranchAfters; // NOI18N
    }
  };
  private /*mutable */ ExtInfo /*P*/ ExtInfo;
  
  /// The number of fixups required by enclosing scopes (not including
  /// this one).  If this is the top cleanup scope, all the fixups
  /// from this index onwards belong to this scope.
  private /*uint*/int FixupDepth;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 267,
   FQN="clang::CodeGen::EHCleanupScope::getExtInfo", NM="_ZN5clang7CodeGen14EHCleanupScope10getExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope10getExtInfoEv")
  //</editor-fold>
  private  ExtInfo /*&*/ getExtInfo() {
    if (!(ExtInfo != null)) {
      ExtInfo = new  ExtInfo();
    }
    return /*Deref*/ExtInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 272,
   FQN="clang::CodeGen::EHCleanupScope::getExtInfo", NM="_ZNK5clang7CodeGen14EHCleanupScope10getExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope10getExtInfoEv")
  //</editor-fold>
  private /*const*/  ExtInfo /*&*/ getExtInfo$Const() /*const*/ {
    if (!(ExtInfo != null)) {
      ExtInfo = new  ExtInfo();
    }
    return /*Deref*/ExtInfo;
  }

/*public:*/
  /// Gets the size required for a lazy cleanup scope with the given
  /// cleanup-data requirements.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getSizeForCleanupSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 280,
   FQN="clang::CodeGen::EHCleanupScope::getSizeForCleanupSize", NM="_ZN5clang7CodeGen14EHCleanupScope21getSizeForCleanupSizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope21getSizeForCleanupSizeEj")
  //</editor-fold>
  public static /*size_t*/int getSizeForCleanupSize(/*size_t*/int Size) {
    return 1/*JAVA*//*$sizeof_EHCleanupScope()*/ + Size;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getAllocatedSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 284,
   FQN="clang::CodeGen::EHCleanupScope::getAllocatedSize", NM="_ZNK5clang7CodeGen14EHCleanupScope16getAllocatedSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope16getAllocatedSizeEv")
  //</editor-fold>
  public /*size_t*/int getAllocatedSize() /*const*/ {
    return 1/*JAVA*//*$sizeof_EHCleanupScope()*/ + Unnamed_field3.CleanupBits.CleanupSize;//$12bits_uint2uint(Unnamed_field3.CleanupBits.CleanupSize);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::EHCleanupScope">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 288,
   FQN="clang::CodeGen::EHCleanupScope::EHCleanupScope", NM="_ZN5clang7CodeGen14EHCleanupScopeC1EbbbjjNS0_12EHScopeStack15stable_iteratorES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScopeC1EbbbjjNS0_12EHScopeStack15stable_iteratorES3_")
  //</editor-fold>
  public EHCleanupScope(boolean isNormal, boolean isEH, boolean isActive, 
      /*uint*/int cleanupSize, /*uint*/int fixupDepth, 
      EHScopeStack.stable_iterator enclosingNormal, 
      EHScopeStack.stable_iterator enclosingEH) {
    // : EHScope(EHScope::Cleanup, enclosingEH), EnclosingNormal(enclosingNormal), EnclosingEH(), NormalBlock(null), ActiveFlag(null), ExtInfo(null), FixupDepth(fixupDepth) 
    //START JInit
    super(EHScope.Kind.Cleanup, new EHScopeStack.stable_iterator(enclosingEH));
    this.EnclosingNormal = new EHScopeStack.stable_iterator(enclosingNormal);
    this.EnclosingEH = new EHScopeStack.stable_iterator();
    this.NormalBlock = null;
    this.ActiveFlag = null;
    this.ExtInfo = null;
    this.FixupDepth = fixupDepth;
    //END JInit
    Unnamed_field3.CleanupBits.IsNormalCleanup = isNormal;
    Unnamed_field3.CleanupBits.IsEHCleanup = isEH;
    Unnamed_field3.CleanupBits.IsActive = isActive;
    Unnamed_field3.CleanupBits.IsLifetimeMarker = false;
    Unnamed_field3.CleanupBits.TestFlagInNormalCleanup = false;
    Unnamed_field3.CleanupBits.TestFlagInEHCleanup = false;
    Unnamed_field3.CleanupBits.CleanupSize = $uint2uint_12bits(cleanupSize);
    assert (Unnamed_field3.CleanupBits.CleanupSize == cleanupSize) : "cleanup size overflow";
    $this_plus_1 = create_char$ptr(new byte[cleanupSize]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::Destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 306,
   FQN="clang::CodeGen::EHCleanupScope::Destroy", NM="_ZN5clang7CodeGen14EHCleanupScope7DestroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope7DestroyEv")
  //</editor-fold>
  public void Destroy() {
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)ExtInfo);
  }

  // Objects of EHCleanupScope are not destructed. Use Destroy().
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::~EHCleanupScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 310,
   FQN="clang::CodeGen::EHCleanupScope::~EHCleanupScope", NM="_ZN5clang7CodeGen14EHCleanupScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScopeD0Ev")
  //</editor-fold>
  public void $destroy() { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::isNormalCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 312,
   FQN="clang::CodeGen::EHCleanupScope::isNormalCleanup", NM="_ZNK5clang7CodeGen14EHCleanupScope15isNormalCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope15isNormalCleanupEv")
  //</editor-fold>
  public boolean isNormalCleanup() /*const*/ {
    return Unnamed_field3.CleanupBits.IsNormalCleanup;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getNormalBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 313,
   FQN="clang::CodeGen::EHCleanupScope::getNormalBlock", NM="_ZNK5clang7CodeGen14EHCleanupScope14getNormalBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope14getNormalBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ getNormalBlock() /*const*/ {
    return NormalBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::setNormalBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 314,
   FQN="clang::CodeGen::EHCleanupScope::setNormalBlock", NM="_ZN5clang7CodeGen14EHCleanupScope14setNormalBlockEPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope14setNormalBlockEPN4llvm10BasicBlockE")
  //</editor-fold>
  public void setNormalBlock(BasicBlock /*P*/ BB) {
    NormalBlock = BB;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::isEHCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 316,
   FQN="clang::CodeGen::EHCleanupScope::isEHCleanup", NM="_ZNK5clang7CodeGen14EHCleanupScope11isEHCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope11isEHCleanupEv")
  //</editor-fold>
  public boolean isEHCleanup() /*const*/ {
    return Unnamed_field3.CleanupBits.IsEHCleanup;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::isActive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 318,
   FQN="clang::CodeGen::EHCleanupScope::isActive", NM="_ZNK5clang7CodeGen14EHCleanupScope8isActiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope8isActiveEv")
  //</editor-fold>
  public boolean isActive() /*const*/ {
    return Unnamed_field3.CleanupBits.IsActive;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::setActive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 319,
   FQN="clang::CodeGen::EHCleanupScope::setActive", NM="_ZN5clang7CodeGen14EHCleanupScope9setActiveEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope9setActiveEb")
  //</editor-fold>
  public void setActive(boolean A) {
    Unnamed_field3.CleanupBits.IsActive = A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::isLifetimeMarker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 321,
   FQN="clang::CodeGen::EHCleanupScope::isLifetimeMarker", NM="_ZNK5clang7CodeGen14EHCleanupScope16isLifetimeMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope16isLifetimeMarkerEv")
  //</editor-fold>
  public boolean isLifetimeMarker() /*const*/ {
    return Unnamed_field3.CleanupBits.IsLifetimeMarker;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::setLifetimeMarker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 322,
   FQN="clang::CodeGen::EHCleanupScope::setLifetimeMarker", NM="_ZN5clang7CodeGen14EHCleanupScope17setLifetimeMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope17setLifetimeMarkerEv")
  //</editor-fold>
  public void setLifetimeMarker() {
    Unnamed_field3.CleanupBits.IsLifetimeMarker = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::hasActiveFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 324,
   FQN="clang::CodeGen::EHCleanupScope::hasActiveFlag", NM="_ZNK5clang7CodeGen14EHCleanupScope13hasActiveFlagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope13hasActiveFlagEv")
  //</editor-fold>
  public boolean hasActiveFlag() /*const*/ {
    return ActiveFlag != null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getActiveFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 325,
   FQN="clang::CodeGen::EHCleanupScope::getActiveFlag", NM="_ZNK5clang7CodeGen14EHCleanupScope13getActiveFlagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope13getActiveFlagEv")
  //</editor-fold>
  public Address getActiveFlag() /*const*/ {
    return new Address(ActiveFlag, CharUnits.One());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::setActiveFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 328,
   FQN="clang::CodeGen::EHCleanupScope::setActiveFlag", NM="_ZN5clang7CodeGen14EHCleanupScope13setActiveFlagENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope13setActiveFlagENS0_7AddressE")
  //</editor-fold>
  public void setActiveFlag(Address Var) {
    assert (Var.getAlignment().isOne());
    ActiveFlag = cast_AllocaInst(Var.getPointer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::setTestFlagInNormalCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 333,
   FQN="clang::CodeGen::EHCleanupScope::setTestFlagInNormalCleanup", NM="_ZN5clang7CodeGen14EHCleanupScope26setTestFlagInNormalCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope26setTestFlagInNormalCleanupEv")
  //</editor-fold>
  public void setTestFlagInNormalCleanup() {
    Unnamed_field3.CleanupBits.TestFlagInNormalCleanup = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::shouldTestFlagInNormalCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 336,
   FQN="clang::CodeGen::EHCleanupScope::shouldTestFlagInNormalCleanup", NM="_ZNK5clang7CodeGen14EHCleanupScope29shouldTestFlagInNormalCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope29shouldTestFlagInNormalCleanupEv")
  //</editor-fold>
  public boolean shouldTestFlagInNormalCleanup() /*const*/ {
    return Unnamed_field3.CleanupBits.TestFlagInNormalCleanup;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::setTestFlagInEHCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 340,
   FQN="clang::CodeGen::EHCleanupScope::setTestFlagInEHCleanup", NM="_ZN5clang7CodeGen14EHCleanupScope22setTestFlagInEHCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope22setTestFlagInEHCleanupEv")
  //</editor-fold>
  public void setTestFlagInEHCleanup() {
    Unnamed_field3.CleanupBits.TestFlagInEHCleanup = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::shouldTestFlagInEHCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 343,
   FQN="clang::CodeGen::EHCleanupScope::shouldTestFlagInEHCleanup", NM="_ZNK5clang7CodeGen14EHCleanupScope25shouldTestFlagInEHCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope25shouldTestFlagInEHCleanupEv")
  //</editor-fold>
  public boolean shouldTestFlagInEHCleanup() /*const*/ {
    return Unnamed_field3.CleanupBits.TestFlagInEHCleanup;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getFixupDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 347,
   FQN="clang::CodeGen::EHCleanupScope::getFixupDepth", NM="_ZNK5clang7CodeGen14EHCleanupScope13getFixupDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope13getFixupDepthEv")
  //</editor-fold>
  public /*uint*/int getFixupDepth() /*const*/ {
    return FixupDepth;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getEnclosingNormalCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 348,
   FQN="clang::CodeGen::EHCleanupScope::getEnclosingNormalCleanup", NM="_ZNK5clang7CodeGen14EHCleanupScope25getEnclosingNormalCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope25getEnclosingNormalCleanupEv")
  //</editor-fold>
  public EHScopeStack.stable_iterator getEnclosingNormalCleanup() /*const*/ {
    return new EHScopeStack.stable_iterator(EnclosingNormal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getCleanupSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 352,
   FQN="clang::CodeGen::EHCleanupScope::getCleanupSize", NM="_ZNK5clang7CodeGen14EHCleanupScope14getCleanupSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope14getCleanupSizeEv")
  //</editor-fold>
  public /*size_t*/int getCleanupSize() /*const*/ {
    return Unnamed_field3.CleanupBits.CleanupSize;//$12bits_uint2uint(Unnamed_field3.CleanupBits.CleanupSize);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getCleanupBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 353,
   FQN="clang::CodeGen::EHCleanupScope::getCleanupBuffer", NM="_ZN5clang7CodeGen14EHCleanupScope16getCleanupBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope16getCleanupBufferEv")
  //</editor-fold>
  public Object/*void P*/ getCleanupBuffer() {
    return $this_plus_1;//this + 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 355,
   FQN="clang::CodeGen::EHCleanupScope::getCleanup", NM="_ZN5clang7CodeGen14EHCleanupScope10getCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope10getCleanupEv")
  //</editor-fold>
  public EHScopeStack.Cleanup /*P*/ getCleanup() {
    return reinterpret_cast(EHScopeStack.Cleanup /*P*/ .class, getCleanupBuffer());
  }

  
  /// True if this cleanup scope has any branch-afters or branch-throughs.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::hasBranches">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 360,
   FQN="clang::CodeGen::EHCleanupScope::hasBranches", NM="_ZNK5clang7CodeGen14EHCleanupScope11hasBranchesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope11hasBranchesEv")
  //</editor-fold>
  public boolean hasBranches() /*const*/ {
    return (ExtInfo != null) && !ExtInfo.Branches.empty();
  }

  
  /// Add a branch-after to this cleanup scope.  A branch-after is a
  /// branch from a point protected by this (normal) cleanup to a
  /// point in the normal cleanup scope immediately containing it.
  /// For example,
  ///   for (;;) { A a; break; }
  /// contains a branch-after.
  ///
  /// Branch-afters each have their own destination out of the
  /// cleanup, guaranteed distinct from anything else threaded through
  /// it.  Therefore branch-afters usually force a switch after the
  /// cleanup.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::addBranchAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 373,
   FQN="clang::CodeGen::EHCleanupScope::addBranchAfter", NM="_ZN5clang7CodeGen14EHCleanupScope14addBranchAfterEPN4llvm11ConstantIntEPNS2_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope14addBranchAfterEPN4llvm11ConstantIntEPNS2_10BasicBlockE")
  //</editor-fold>
  public void addBranchAfter(ConstantInt /*P*/ Index, 
                BasicBlock /*P*/ Block) {
    final  ExtInfo /*&*/ $ExtInfo = getExtInfo();
    if ($ExtInfo.Branches.insert(Block).second) {
      $ExtInfo.BranchAfters.push_back(std.make_pair_Ptr_Ptr(Block, Index));
    }
  }

  
  /// Return the number of unique branch-afters on this scope.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getNumBranchAfters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 381,
   FQN="clang::CodeGen::EHCleanupScope::getNumBranchAfters", NM="_ZNK5clang7CodeGen14EHCleanupScope18getNumBranchAftersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope18getNumBranchAftersEv")
  //</editor-fold>
  public /*uint*/int getNumBranchAfters() /*const*/ {
    return (ExtInfo != null) ? ExtInfo.BranchAfters.size() : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getBranchAfterBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 385,
   FQN="clang::CodeGen::EHCleanupScope::getBranchAfterBlock", NM="_ZNK5clang7CodeGen14EHCleanupScope19getBranchAfterBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope19getBranchAfterBlockEj")
  //</editor-fold>
  public BasicBlock /*P*/ getBranchAfterBlock(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumBranchAfters()));
    return ExtInfo.BranchAfters.$at(I).first;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::getBranchAfterIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 390,
   FQN="clang::CodeGen::EHCleanupScope::getBranchAfterIndex", NM="_ZNK5clang7CodeGen14EHCleanupScope19getBranchAfterIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope19getBranchAfterIndexEj")
  //</editor-fold>
  public ConstantInt /*P*/ getBranchAfterIndex(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumBranchAfters()));
    return ExtInfo.BranchAfters.$at(I).second;
  }

  
  /// Add a branch-through to this cleanup scope.  A branch-through is
  /// a branch from a scope protected by this (normal) cleanup to an
  /// enclosing scope other than the immediately-enclosing normal
  /// cleanup scope.
  ///
  /// In the following example, the branch through B's scope is a
  /// branch-through, while the branch through A's scope is a
  /// branch-after:
  ///   for (;;) { A a; B b; break; }
  ///
  /// All branch-throughs have a common destination out of the
  /// cleanup, one possibly shared with the fall-through.  Therefore
  /// branch-throughs usually don't force a switch after the cleanup.
  ///
  /// \return true if the branch-through was new to this scope
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::addBranchThrough">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 410,
   FQN="clang::CodeGen::EHCleanupScope::addBranchThrough", NM="_ZN5clang7CodeGen14EHCleanupScope16addBranchThroughEPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope16addBranchThroughEPN4llvm10BasicBlockE")
  //</editor-fold>
  public boolean addBranchThrough(BasicBlock /*P*/ Block) {
    return getExtInfo().Branches.insert(Block).second;
  }

  
  /// Determines if this cleanup scope has any branch throughs.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::hasBranchThroughs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 415,
   FQN="clang::CodeGen::EHCleanupScope::hasBranchThroughs", NM="_ZNK5clang7CodeGen14EHCleanupScope17hasBranchThroughsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen14EHCleanupScope17hasBranchThroughsEv")
  //</editor-fold>
  public boolean hasBranchThroughs() /*const*/ {
    if (!(ExtInfo != null)) {
      return false;
    }
    return (ExtInfo.BranchAfters.size() != ExtInfo.Branches.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCleanupScope::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 420,
   FQN="clang::CodeGen::EHCleanupScope::classof", NM="_ZN5clang7CodeGen14EHCleanupScope7classofEPKNS0_7EHScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen14EHCleanupScope7classofEPKNS0_7EHScopeE")
  //</editor-fold>
  public static boolean classof(/*const*/ EHScope /*P*/ Scope) {
    return (Scope.getKind() == Kind.Cleanup);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final char$ptr $this_plus_1;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "EnclosingNormal=" + EnclosingNormal // NOI18N
              + ", EnclosingEH=" + EnclosingEH // NOI18N
              + ", NormalBlock=" + NormalBlock // NOI18N
              + ", ActiveFlag=" + ActiveFlag // NOI18N
              + ", ExtInfo=" + ExtInfo // NOI18N
              + ", FixupDepth=" + FixupDepth // NOI18N
              + super.toString(); // NOI18N
  }
}
