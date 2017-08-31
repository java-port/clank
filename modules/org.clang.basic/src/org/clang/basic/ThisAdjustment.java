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
import static org.clank.support.Native.*;
import org.clang.basic.*;


/// \brief A \c this pointer adjustment.
//<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 108,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 105,
 FQN="clang::ThisAdjustment", NM="_ZN5clang14ThisAdjustmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustmentE")
//</editor-fold>
public class/*struct*/ ThisAdjustment {
  /// \brief The non-virtual adjustment from the derived object to its
  /// nearest virtual base.
  public long/*int64_t*/ NonVirtual;
  
  /// \brief Holds the ABI-specific information about the virtual this
  /// adjustment, if needed.
  //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 112,
   FQN="clang::ThisAdjustment::VirtualAdjustment", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentE")
  //</editor-fold>
  public static class/*union*/ VirtualAdjustment implements NativePOD<VirtualAdjustment> {
    // Itanium ABI
    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 117,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 114,
     FQN="clang::ThisAdjustment::VirtualAdjustment::(anonymous)", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentE_Unnamed_struct1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentE_Unnamed_struct1")
    //</editor-fold>
    public static class/*struct*/ Unnamed_struct1 implements NativePOD<Unnamed_struct1> {
      /// \brief The offset (in bytes), relative to the address point,
      /// of the virtual call offset.
      public long/*int64_t*/ VCallOffsetOffset;

      @Converted(kind = Converted.Kind.MANUAL_ADDED)
      public Unnamed_struct1() {
      }

      @Converted(kind = Converted.Kind.MANUAL_ADDED)
      public Unnamed_struct1(Unnamed_struct1 other) {
        this.VCallOffsetOffset = other.VCallOffsetOffset;
      }

      @Converted(kind = Converted.Kind.MANUAL_ADDED)
      @Override
      public Unnamed_struct1 clone() {
        return new Unnamed_struct1(this);
      }

      @Converted(kind = Converted.Kind.MANUAL_ADDED)
      @Override
      public boolean $eq(Unnamed_struct1 other) {
        if (this.VCallOffsetOffset != other.VCallOffsetOffset) {
          return false;
        }
        return true;
      }
      
      //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::(anonymous struct)::operator=">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 117,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 114,
       FQN="clang::ThisAdjustment::VirtualAdjustment::(anonymous struct)::operator=", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentUt_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentUt_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct1 $assign(Unnamed_struct1 $Prm0) {
        this.VCallOffsetOffset = $Prm0.VCallOffsetOffset;
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::(anonymous struct)::operator=">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 117,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 114,
       FQN="clang::ThisAdjustment::VirtualAdjustment::(anonymous struct)::operator=", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentUt_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentUt_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct1 $assignMove(Unnamed_struct1 $Prm0) {
        this.VCallOffsetOffset = $Prm0.VCallOffsetOffset;
        return /*Deref*/this;
      }

      
      public String toString() {
        return "" + "VCallOffsetOffset=" + VCallOffsetOffset; // NOI18N
      }
    };
    public Unnamed_struct1 Itanium;
    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 123,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 120,
     FQN="clang::ThisAdjustment::VirtualAdjustment::(anonymous)", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentE_Unnamed_struct2",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentE_Unnamed_struct2")
    //</editor-fold>
    public static class/*struct*/ Unnamed_struct2 implements NativePOD<Unnamed_struct2> {
      /// \brief The offset of the vtordisp (in bytes), relative to the ECX.
      public int/*int32_t*/ VtordispOffset;
      
      /// \brief The offset of the vbptr of the derived class (in bytes),
      /// relative to the ECX after vtordisp adjustment.
      public int/*int32_t*/ VBPtrOffset;
      
      /// \brief The offset (in bytes) of the vbase offset in the vbtable.
      public int/*int32_t*/ VBOffsetOffset;

      @Converted(kind = Converted.Kind.MANUAL_ADDED)
      private Unnamed_struct2() {
      }
      
      @Converted(kind = Converted.Kind.MANUAL_ADDED)
      private Unnamed_struct2(Unnamed_struct2 other) {
        this.VtordispOffset = other.VtordispOffset;
        this.VBPtrOffset = other.VBPtrOffset;
        this.VBOffsetOffset = other.VBOffsetOffset;
      }
      
      //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::(anonymous struct)::operator=">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 123,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 120,
       FQN="clang::ThisAdjustment::VirtualAdjustment::(anonymous struct)::operator=", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentUt0_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentUt0_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct2 $assign(Unnamed_struct2 $Prm0) {
        
        this.VtordispOffset = $Prm0.VtordispOffset;
        
        this.VBPtrOffset = $Prm0.VBPtrOffset;
        
        this.VBOffsetOffset = $Prm0.VBOffsetOffset;
        
        return /*Deref*/this;
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::(anonymous struct)::operator=">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 123,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 120,
       FQN="clang::ThisAdjustment::VirtualAdjustment::(anonymous struct)::operator=", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentUt0_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentUt0_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct2 $assignMove(Unnamed_struct2 $Prm0) {
        
        this.VtordispOffset = $Prm0.VtordispOffset;
        
        this.VBPtrOffset = $Prm0.VBPtrOffset;
        
        this.VBOffsetOffset = $Prm0.VBOffsetOffset;
        
        return /*Deref*/this;
      }

      
      public String toString() {
        return "" + "VtordispOffset=" + VtordispOffset // NOI18N
                  + ", VBPtrOffset=" + VBPtrOffset // NOI18N
                  + ", VBOffsetOffset=" + VBOffsetOffset; // NOI18N
      }

      @Converted(kind = Converted.Kind.MANUAL_ADDED)
      @Override
      public Unnamed_struct2 clone() {
        return new Unnamed_struct2(this);
      }

      @Converted(kind = Converted.Kind.MANUAL_ADDED)
      @Override
      public boolean $eq(Unnamed_struct2 other) {
        if (this.VtordispOffset != other.VtordispOffset) {
          return false;
        }
        if (this.VBPtrOffset != other.VBPtrOffset) {
          return false;
        }
        if (this.VBOffsetOffset != other.VBOffsetOffset) {
          return false;
        }
        return true;
      }
    };
    
    public Unnamed_struct2 Microsoft;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::VirtualAdjustment">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 135,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 132,
     FQN="clang::ThisAdjustment::VirtualAdjustment::VirtualAdjustment", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentC1Ev")
    //</editor-fold>
    public VirtualAdjustment() {
      // JAVA: create empty fields
      this.Itanium = new Unnamed_struct1();
      this.Microsoft = new Unnamed_struct2();
//      memset(this, 0, sizeof (/*Deref*/this));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::Equals">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 139,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 136,
     FQN="clang::ThisAdjustment::VirtualAdjustment::Equals", NM="_ZNK5clang14ThisAdjustment17VirtualAdjustment6EqualsERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang14ThisAdjustment17VirtualAdjustment6EqualsERKS1_")
    //</editor-fold>
    public boolean Equals(/*const*/ VirtualAdjustment /*&*/ Other) /*const*/ {
      return this.Itanium.$eq(Other.Itanium) && this.Microsoft.$eq(Other.Microsoft);
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public boolean $eq(VirtualAdjustment other) {
      return Equals(other);
    }

    @Override
    public VirtualAdjustment clone() {
      return new VirtualAdjustment(this);
    }    
    
    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::isEmpty">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 143,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 140,
     FQN="clang::ThisAdjustment::VirtualAdjustment::isEmpty", NM="_ZNK5clang14ThisAdjustment17VirtualAdjustment7isEmptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang14ThisAdjustment17VirtualAdjustment7isEmptyEv")
    //</editor-fold>
    public boolean isEmpty() /*const*/ {
      VirtualAdjustment Zero/*J*/= new VirtualAdjustment();
      return Equals(Zero);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::Less">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 148,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 145,
     FQN="clang::ThisAdjustment::VirtualAdjustment::Less", NM="_ZNK5clang14ThisAdjustment17VirtualAdjustment4LessERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang14ThisAdjustment17VirtualAdjustment4LessERKS1_")
    //</editor-fold>
    public boolean Less(/*const*/ VirtualAdjustment /*&*/ RHS) /*const*/ {
      if (this.Itanium.VCallOffsetOffset != RHS.Itanium.VCallOffsetOffset) {
        return this.Itanium.VCallOffsetOffset < RHS.Itanium.VCallOffsetOffset;
      }
      if (this.Microsoft.VtordispOffset != RHS.Microsoft.VtordispOffset) {
        return this.Microsoft.VtordispOffset < RHS.Microsoft.VtordispOffset;
      }
      if (this.Microsoft.VBPtrOffset != RHS.Microsoft.VBPtrOffset) {
        return this.Microsoft.VBPtrOffset < RHS.Microsoft.VBPtrOffset;
      }
      return this.Microsoft.VBOffsetOffset < RHS.Microsoft.VBOffsetOffset;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::VirtualAdjustment">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 115,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 112,
     FQN="clang::ThisAdjustment::VirtualAdjustment::VirtualAdjustment", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentC1ERKS1_")
    //</editor-fold>
    public /*inline*/ VirtualAdjustment(/*const*/ VirtualAdjustment /*&*/ $Prm0) {
      this.Itanium = $Prm0.Itanium;
      this.Microsoft = $Prm0.Microsoft;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::VirtualAdjustment">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 115,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 112,
     FQN="clang::ThisAdjustment::VirtualAdjustment::VirtualAdjustment", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentC1EOS1_")
    //</editor-fold>
    public /*inline*/ VirtualAdjustment(JD$Move _dparam, VirtualAdjustment /*&&*/$Prm0) {
      this.Itanium = $Prm0.Itanium;
      this.Microsoft = $Prm0.Microsoft;      
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 115,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 112,
     FQN="clang::ThisAdjustment::VirtualAdjustment::operator=", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentaSERKS1_")
    //</editor-fold>
    public /*inline*/ VirtualAdjustment /*&*/ $assign(/*const*/ VirtualAdjustment /*&*/ $Prm0) {
      this.Itanium.$assign($Prm0.Itanium);
      this.Microsoft.$assign($Prm0.Microsoft);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::VirtualAdjustment::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 115,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 112,
     FQN="clang::ThisAdjustment::VirtualAdjustment::operator=", NM="_ZN5clang14ThisAdjustment17VirtualAdjustmentaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustment17VirtualAdjustmentaSEOS1_")
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
  
  //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::ThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 153,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 150,
   FQN="clang::ThisAdjustment::ThisAdjustment", NM="_ZN5clang14ThisAdjustmentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustmentC1Ev")
  //</editor-fold>
  public ThisAdjustment() {
    /* : NonVirtual(0), Virtual()*/ 
    //START JInit
    this.NonVirtual = 0;
    this.Virtual = new  VirtualAdjustment();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::isEmpty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 155,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 152,
   FQN="clang::ThisAdjustment::isEmpty", NM="_ZNK5clang14ThisAdjustment7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang14ThisAdjustment7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return !(NonVirtual != 0) && Virtual.isEmpty();
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 157,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 154,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_14ThisAdjustmentES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clangeqERKNS_14ThisAdjustmentES2_")
  //</editor-fold>
  public static boolean $eq_ThisAdjustment$C(/*const*/ ThisAdjustment /*&*/ LHS, 
                    /*const*/ ThisAdjustment /*&*/ RHS) {
    return LHS.NonVirtual == RHS.NonVirtual && LHS.Virtual.Equals(RHS.Virtual);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 159,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_14ThisAdjustmentES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clangneERKNS_14ThisAdjustmentES2_")
  //</editor-fold>
  public static boolean $noteq_ThisAdjustment$C(/*const*/ ThisAdjustment /*&*/ LHS, /*const*/ ThisAdjustment /*&*/ RHS) {
    return !($eq_ThisAdjustment$C(LHS, RHS));
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 163,
   FQN="clang::operator<", NM="_ZN5clangltERKNS_14ThisAdjustmentES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clangltERKNS_14ThisAdjustmentES2_")
  //</editor-fold>
  public static boolean $less_ThisAdjustment$C(/*const*/ ThisAdjustment /*&*/ LHS, 
                      /*const*/ ThisAdjustment /*&*/ RHS) {
    if (LHS.NonVirtual < RHS.NonVirtual) {
      return true;
    }
    
    return LHS.NonVirtual == RHS.NonVirtual && LHS.Virtual.Less(RHS.Virtual);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::ThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 105,
   FQN="clang::ThisAdjustment::ThisAdjustment", NM="_ZN5clang14ThisAdjustmentC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustmentC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ThisAdjustment(/*const*/ ThisAdjustment /*&*/ $Prm0) {
    /* : NonVirtual(.NonVirtual), Virtual(.Virtual)*/ 
    //START JInit
    this.NonVirtual = $Prm0.NonVirtual;
    this.Virtual = new  VirtualAdjustment($Prm0.Virtual);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::ThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 105,
   FQN="clang::ThisAdjustment::ThisAdjustment", NM="_ZN5clang14ThisAdjustmentC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustmentC1EOS0_")
  //</editor-fold>
  public /*inline*/ ThisAdjustment(JD$Move _dparam, ThisAdjustment /*&&*/$Prm0) {
    /* : NonVirtual(static_cast<ThisAdjustment &&>().NonVirtual), Virtual(static_cast<ThisAdjustment &&>().Virtual)*/ 
    //START JInit
    this.NonVirtual = $Prm0.NonVirtual;
    this.Virtual = new  VirtualAdjustment(JD$Move.INSTANCE, $Prm0.Virtual);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 105,
   FQN="clang::ThisAdjustment::operator=", NM="_ZN5clang14ThisAdjustmentaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustmentaSERKS0_")
  //</editor-fold>
  public /*inline*/ ThisAdjustment /*&*/ $assign(/*const*/ ThisAdjustment /*&*/ $Prm0) {
    this.NonVirtual = $Prm0.NonVirtual;
    this.Virtual.$assign($Prm0.Virtual);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ThisAdjustment::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 105,
   FQN="clang::ThisAdjustment::operator=", NM="_ZN5clang14ThisAdjustmentaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang14ThisAdjustmentaSEOS0_")
  //</editor-fold>
  public /*inline*/ ThisAdjustment /*&*/ $assignMove(ThisAdjustment /*&&*/$Prm0) {
    this.NonVirtual = $Prm0.NonVirtual;
    this.Virtual.$assignMove($Prm0.Virtual);
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "NonVirtual=" + NonVirtual // NOI18N
              + ", Virtual=" + Virtual; // NOI18N
  }
}
