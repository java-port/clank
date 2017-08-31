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
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;


/// \brief A return adjustment.
//<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 42,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 39,
 FQN="clang::ReturnAdjustment", NM="_ZN5clang16ReturnAdjustmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustmentE")
//</editor-fold>
public class/*struct*/ ReturnAdjustment {
  /// \brief The non-virtual adjustment from the derived object to its
  /// nearest virtual base.
  public long/*int64_t*/ NonVirtual;
  
  /// \brief Holds the ABI-specific information about the virtual return
  /// adjustment, if needed.
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 46,
   FQN="clang::ReturnAdjustment::VirtualAdjustment", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentE")
  //</editor-fold>
  public static class/*union*/ VirtualAdjustment implements Native.NativePOD<VirtualAdjustment>, Native.ComparableLower {

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public VirtualAdjustment clone() {
      return new VirtualAdjustment(this);
    }

    @Override
    public boolean $eq(VirtualAdjustment other) {
      return Equals(other);
    }

    @Override
    public boolean $less(Object obj) {
      return Less((VirtualAdjustment)obj);
    }
    
    // Itanium ABI
    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 51,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 48,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::(anonymous)", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentE_Unnamed_struct1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentE_Unnamed_struct1")
    //</editor-fold>
    public static class/*struct*/ Unnamed_struct1 {
      /// \brief The offset (in bytes), relative to the address point
      /// of the virtual base class offset.
      public long/*int64_t*/ VBaseOffsetOffset;
      //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::(anonymous struct)::operator=">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 51,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 48,
       FQN="clang::ReturnAdjustment::VirtualAdjustment::(anonymous struct)::operator=", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentUt_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentUt_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct1 $assign(Unnamed_struct1 $Prm0) {
        this.VBaseOffsetOffset = $Prm0.VBaseOffsetOffset;
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::(anonymous struct)::operator=">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 51,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 48,
       FQN="clang::ReturnAdjustment::VirtualAdjustment::(anonymous struct)::operator=", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentUt_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentUt_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct1 $assignMove(Unnamed_struct1 $Prm0) {
        this.VBaseOffsetOffset = $Prm0.VBaseOffsetOffset;
        return /*Deref*/this;
      }

      
      public String toString() {
        return "" + "VBaseOffsetOffset=" + VBaseOffsetOffset; // NOI18N
      }
    };
    public Unnamed_struct1 Itanium;
    
    // Microsoft ABI
    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 58,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 55,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::(anonymous)", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentE_Unnamed_struct2",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentE_Unnamed_struct2")
    //</editor-fold>
    public static class/*struct*/ Unnamed_struct2 {
      /// \brief The offset (in bytes) of the vbptr, relative to the beginning
      /// of the derived class.
      public /*uint32_t*/int VBPtrOffset;
      
      /// \brief Index of the virtual base in the vbtable.
      public /*uint32_t*/int VBIndex;
      //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::(anonymous struct)::operator=">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 58,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 55,
       FQN="clang::ReturnAdjustment::VirtualAdjustment::(anonymous struct)::operator=", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentUt0_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentUt0_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct2 $assign(Unnamed_struct2 $Prm0) {
        this.VBPtrOffset = $Prm0.VBPtrOffset;
        this.VBIndex = $Prm0.VBIndex;
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::(anonymous struct)::operator=">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 58,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 55,
       FQN="clang::ReturnAdjustment::VirtualAdjustment::(anonymous struct)::operator=", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentUt0_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentUt0_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct2 $assignMove(Unnamed_struct2 $Prm0) {
        this.VBPtrOffset = $Prm0.VBPtrOffset;
        this.VBIndex = $Prm0.VBIndex;
        return /*Deref*/this;
      }

      
      public String toString() {
        return "" + "VBPtrOffset=" + VBPtrOffset // NOI18N
                  + ", VBIndex=" + VBIndex; // NOI18N
      }
    };
    public Unnamed_struct2 Microsoft;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::VirtualAdjustment">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 67,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 64,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::VirtualAdjustment", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentC1Ev")
    //</editor-fold>
    public VirtualAdjustment() {
      this.Itanium = new Unnamed_struct1();
      this.Microsoft = new Unnamed_struct2();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::Equals">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 71,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 68,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::Equals", NM="_ZNK5clang16ReturnAdjustment17VirtualAdjustment6EqualsERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang16ReturnAdjustment17VirtualAdjustment6EqualsERKS1_")
    //</editor-fold>
    public boolean Equals(/*const*/ VirtualAdjustment /*&*/ Other) /*const*/ {
      return this.Itanium.VBaseOffsetOffset == Other.Itanium.VBaseOffsetOffset &&
              this.Microsoft.VBPtrOffset == Other.Microsoft.VBPtrOffset && 
              this.Microsoft.VBIndex == Other.Microsoft.VBIndex;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::isEmpty">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 75,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 72,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::isEmpty", NM="_ZNK5clang16ReturnAdjustment17VirtualAdjustment7isEmptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang16ReturnAdjustment17VirtualAdjustment7isEmptyEv")
    //</editor-fold>
    public boolean isEmpty() /*const*/ {
      VirtualAdjustment Zero/*J*/= new VirtualAdjustment();
      return Equals(Zero);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::Less">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 80,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 77,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::Less", NM="_ZNK5clang16ReturnAdjustment17VirtualAdjustment4LessERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang16ReturnAdjustment17VirtualAdjustment4LessERKS1_")
    //</editor-fold>
    public boolean Less(/*const*/ VirtualAdjustment /*&*/ RHS) /*const*/ {
      if (this.Itanium.VBaseOffsetOffset != RHS.Itanium.VBaseOffsetOffset) {
        return this.Itanium.VBaseOffsetOffset < RHS.Itanium.VBaseOffsetOffset;
      }
      if (this.Microsoft.VBPtrOffset != RHS.Microsoft.VBPtrOffset) {
        return $less_uint(this.Microsoft.VBPtrOffset, RHS.Microsoft.VBPtrOffset);
      }
      return $less_uint(this.Microsoft.VBIndex, RHS.Microsoft.VBIndex);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::VirtualAdjustment">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 49,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 46,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::VirtualAdjustment", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentC1ERKS1_")
    //</editor-fold>
    public /*inline*/ VirtualAdjustment(/*const*/ VirtualAdjustment /*&*/ $Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::VirtualAdjustment">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 49,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 46,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::VirtualAdjustment", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentC1EOS1_")
    //</editor-fold>
    public /*inline*/ VirtualAdjustment(JD$Move _dparam, VirtualAdjustment /*&&*/$Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 49,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 46,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::operator=", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentaSERKS1_")
    //</editor-fold>
    public /*inline*/ VirtualAdjustment /*&*/ $assign(/*const*/ VirtualAdjustment /*&*/ $Prm0) {
      this.Itanium.$assign($Prm0.Itanium);
      this.Microsoft.$assign($Prm0.Microsoft);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::VirtualAdjustment::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 49,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 46,
     FQN="clang::ReturnAdjustment::VirtualAdjustment::operator=", NM="_ZN5clang16ReturnAdjustment17VirtualAdjustmentaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustment17VirtualAdjustmentaSEOS1_")
    //</editor-fold>
    public /*inline*/ VirtualAdjustment /*&*/ $assignMove(VirtualAdjustment /*&&*/$Prm0) {
      this.Itanium.$assignMove($Prm0.Itanium);
      this.Microsoft.$assignMove($Prm0.Microsoft);
      return /*Deref*/this;
    }

    
    public String toString() {
      return "" + "Itanium=" + Itanium // NOI18N
                + ", Microsoft=" + Microsoft; // NOI18N
    }
  };
  public  VirtualAdjustment Virtual;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::ReturnAdjustment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 85,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 82,
   FQN="clang::ReturnAdjustment::ReturnAdjustment", NM="_ZN5clang16ReturnAdjustmentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustmentC1Ev")
  //</editor-fold>
  public ReturnAdjustment() {
    /* : NonVirtual(0), Virtual()*/ 
    //START JInit
    this.NonVirtual = 0;
    this.Virtual = new  VirtualAdjustment();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::isEmpty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 84,
   FQN="clang::ReturnAdjustment::isEmpty", NM="_ZNK5clang16ReturnAdjustment7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang16ReturnAdjustment7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return !(NonVirtual != 0) && Virtual.isEmpty();
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 89,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 86,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_16ReturnAdjustmentES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clangeqERKNS_16ReturnAdjustmentES2_")
  //</editor-fold>
  public static boolean $eq_ReturnAdjustment$C(/*const*/ ReturnAdjustment /*&*/ LHS, 
                      /*const*/ ReturnAdjustment /*&*/ RHS) {
    return LHS.NonVirtual == RHS.NonVirtual && LHS.Virtual.Equals(RHS.Virtual);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 94,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 91,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_16ReturnAdjustmentES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clangneERKNS_16ReturnAdjustmentES2_")
  //</editor-fold>
  public static boolean $noteq_ReturnAdjustment$C(/*const*/ ReturnAdjustment /*&*/ LHS, /*const*/ ReturnAdjustment /*&*/ RHS) {
    return !($eq_ReturnAdjustment$C(LHS, RHS));
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 98,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 95,
   FQN="clang::operator<", NM="_ZN5clangltERKNS_16ReturnAdjustmentES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clangltERKNS_16ReturnAdjustmentES2_")
  //</editor-fold>
  public static boolean $less_ReturnAdjustment$C(/*const*/ ReturnAdjustment /*&*/ LHS, 
                        /*const*/ ReturnAdjustment /*&*/ RHS) {
    if (LHS.NonVirtual < RHS.NonVirtual) {
      return true;
    }
    
    return LHS.NonVirtual == RHS.NonVirtual && LHS.Virtual.Less(RHS.Virtual);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::ReturnAdjustment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 39,
   FQN="clang::ReturnAdjustment::ReturnAdjustment", NM="_ZN5clang16ReturnAdjustmentC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustmentC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ReturnAdjustment(/*const*/ ReturnAdjustment /*&*/ $Prm0) {
    /* : NonVirtual(.NonVirtual), Virtual(.Virtual)*/ 
    //START JInit
    this.NonVirtual = $Prm0.NonVirtual;
    this.Virtual = new  VirtualAdjustment($Prm0.Virtual);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::ReturnAdjustment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 39,
   FQN="clang::ReturnAdjustment::ReturnAdjustment", NM="_ZN5clang16ReturnAdjustmentC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustmentC1EOS0_")
  //</editor-fold>
  public /*inline*/ ReturnAdjustment(JD$Move _dparam, ReturnAdjustment /*&&*/$Prm0) {
    /* : NonVirtual(static_cast<ReturnAdjustment &&>().NonVirtual), Virtual(static_cast<ReturnAdjustment &&>().Virtual)*/ 
    //START JInit
    this.NonVirtual = $Prm0.NonVirtual;
    this.Virtual = new  VirtualAdjustment(JD$Move.INSTANCE, $Prm0.Virtual);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 39,
   FQN="clang::ReturnAdjustment::operator=", NM="_ZN5clang16ReturnAdjustmentaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustmentaSERKS0_")
  //</editor-fold>
  public /*inline*/ ReturnAdjustment /*&*/ $assign(/*const*/ ReturnAdjustment /*&*/ $Prm0) {
    this.NonVirtual = $Prm0.NonVirtual;
    this.Virtual.$assign($Prm0.Virtual);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReturnAdjustment::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 39,
   FQN="clang::ReturnAdjustment::operator=", NM="_ZN5clang16ReturnAdjustmentaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang16ReturnAdjustmentaSEOS0_")
  //</editor-fold>
  public /*inline*/ ReturnAdjustment /*&*/ $assignMove(ReturnAdjustment /*&&*/$Prm0) {
    this.NonVirtual = $Prm0.NonVirtual;
    this.Virtual.$assignMove($Prm0.Virtual);
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "NonVirtual=" + NonVirtual // NOI18N
              + ", Virtual=" + Virtual; // NOI18N
  }
}
