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

package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIDerivedType>">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 343,
 FQN="llvm::MDNodeKeyImpl<DIDerivedType>", NM="_ZN4llvm13MDNodeKeyImplINS_13DIDerivedTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_13DIDerivedTypeEEE")
//</editor-fold>
public class/*struct*/ MDNodeKeyImplDIDerivedType implements MDNodeKeyImpl<DIDerivedType> {
  public /*uint*/int _Tag;
  public MDString /*P*/ Name;
  public Metadata /*P*/ File;
  public /*uint*/int Line;
  public Metadata /*P*/ Scope;
  public Metadata /*P*/ BaseType;
  public long/*uint64_t*/ SizeInBits;
  public long/*uint64_t*/ AlignInBits;
  public long/*uint64_t*/ OffsetInBits;
  public /*uint*/int Flags;
  public Metadata /*P*/ ExtraData;

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIDerivedType>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 356,
   FQN="llvm::MDNodeKeyImpl<DIDerivedType>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_13DIDerivedTypeEEC1EjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_13DIDerivedTypeEEC1EjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_")
  //</editor-fold>
  public MDNodeKeyImplDIDerivedType(/*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line,
      Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits,
      long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags,
      Metadata /*P*/ ExtraData) {
    // : Tag(Tag), Name(Name), File(File), Line(Line), Scope(Scope), BaseType(BaseType), SizeInBits(SizeInBits), AlignInBits(AlignInBits), OffsetInBits(OffsetInBits), Flags(Flags), ExtraData(ExtraData)
    //START JInit
    this._Tag = Tag;
    this.Name = Name;
    this.File = File;
    this.Line = Line;
    this.Scope = Scope;
    this.BaseType = BaseType;
    this.SizeInBits = SizeInBits;
    this.AlignInBits = AlignInBits;
    this.OffsetInBits = OffsetInBits;
    this.Flags = Flags;
    this.ExtraData = ExtraData;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIDerivedType>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 363,
   FQN="llvm::MDNodeKeyImpl<DIDerivedType>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_13DIDerivedTypeEEC1EPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_13DIDerivedTypeEEC1EPKS1_")
  //</editor-fold>
  public MDNodeKeyImplDIDerivedType(/*const*/ DIDerivedType /*P*/ N) {
    // : Tag(N->getTag()), Name(N->getRawName()), File(N->getRawFile()), Line(N->getLine()), Scope(N->getRawScope()), BaseType(N->getRawBaseType()), SizeInBits(N->getSizeInBits()), AlignInBits(N->getAlignInBits()), OffsetInBits(N->getOffsetInBits()), Flags(N->getFlags()), ExtraData(N->getRawExtraData())
    //START JInit
    this._Tag = N.getTag();
    this.Name = N.getRawName();
    this.File = N.getRawFile();
    this.Line = N.getLine();
    this.Scope = N.getRawScope();
    this.BaseType = N.getRawBaseType();
    this.SizeInBits = N.getSizeInBits();
    this.AlignInBits = N.getAlignInBits();
    this.OffsetInBits = N.getOffsetInBits();
    this.Flags = N.getFlags();
    this.ExtraData = N.getRawExtraData();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIDerivedType>::isKeyOf">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 370,
   FQN="llvm::MDNodeKeyImpl<DIDerivedType>::isKeyOf", NM="_ZNK4llvm13MDNodeKeyImplINS_13DIDerivedTypeEE7isKeyOfEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_13DIDerivedTypeEE7isKeyOfEPKS1_")
  //</editor-fold>
  public boolean isKeyOf(/*const*/ DIDerivedType /*P*/ RHS) /*const*/ {
    return _Tag == RHS.getTag() && Name == RHS.getRawName()
       && File == RHS.getRawFile() && Line == RHS.getLine()
       && Scope == RHS.getRawScope() && BaseType == RHS.getRawBaseType()
       && SizeInBits == RHS.getSizeInBits()
       && AlignInBits == RHS.getAlignInBits()
       && OffsetInBits == RHS.getOffsetInBits() && Flags == RHS.getFlags()
       && ExtraData == RHS.getRawExtraData();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIDerivedType>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 379,
   FQN="llvm::MDNodeKeyImpl<DIDerivedType>::getHashValue", NM="_ZNK4llvm13MDNodeKeyImplINS_13DIDerivedTypeEE12getHashValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_13DIDerivedTypeEE12getHashValueEv")
  //</editor-fold>
  public /*uint*/int getHashValue() /*const*/ {
    // If this is a member inside an ODR type, only hash the type and the name.
    // Otherwise the hash will be stronger than
    // MDNodeSubsetEqualImpl::isODRMember().
    if (_Tag == $ushort2uint(Tag.DW_TAG_member) && (Name != null)) {
      {
        DICompositeType /*P*/ CT = dyn_cast_or_null_DICompositeType(Scope);
        if ((CT != null)) {
          if ((CT.getRawIdentifier() != null)) {
            return hash_combine_ptrs(Name, Scope).$uint();
          }
        }
      }
    }

    // Intentionally computes the hash on a subset of the operands for
    // performance reason. The subset has to be significant enough to avoid
    // collision "most of the time". There is no correctness issue in case of
    // collision because of the full check above.
    return hash_combine(_Tag, hash_value_ptr(Name), hash_value_ptr(File), Line, hash_value_ptr(Scope), hash_value_ptr(BaseType), Flags).$uint();
  }


  @Override public String toString() {
    return "" + "Tag=" + _Tag// NOI18N
              + ", Name=" + Name // NOI18N
              + ", File=" + File // NOI18N
              + ", Line=" + Line // NOI18N
              + ", Scope=" + Scope // NOI18N
              + ", BaseType=" + BaseType // NOI18N
              + ", SizeInBits=" + SizeInBits // NOI18N
              + ", AlignInBits=" + AlignInBits // NOI18N
              + ", OffsetInBits=" + OffsetInBits // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", ExtraData=" + ExtraData; // NOI18N
  }
}
