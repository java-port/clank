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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Local variable.
///
/// TODO: Split up flags.
//<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1936,
 FQN="llvm::DILocalVariable", NM="_ZN4llvm15DILocalVariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariableE")
//</editor-fold>
public class DILocalVariable extends /*public*/ DIVariable implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*JCHAR unsigned int*/ char Arg /*: 16*/;
  private /*JCHAR unsigned int*/ char Flags /*: 16*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::DILocalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1943,
   FQN="llvm::DILocalVariable::DILocalVariable", NM="_ZN4llvm15DILocalVariableC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariableC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DILocalVariable(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Line,
      /*uint*/int Arg, /*uint*/int Flags, ArrayRef<Metadata /*P*/ > Ops) {
    // : DIVariable(C, DILocalVariableKind, Storage, Line, Ops), Arg(Arg), Flags(Flags)
    //START JInit
    super(C, MetadataKind.DILocalVariableKind.getValue(), Storage, Line, new ArrayRef<Metadata /*P*/ >(Ops));
    this.Arg = $uint2uint_16bits(Arg);
    this.Flags = $uint2uint_16bits(Flags);
    //END JInit
    assert ($less_uint(Flags, (1 << 16))) : "DILocalVariable: Flags out of range";
    assert ($less_uint(Arg, (1 << 16))) : "DILocalVariable: Arg out of range";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::~DILocalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1950,
   FQN="llvm::DILocalVariable::~DILocalVariable", NM="_ZN4llvm15DILocalVariableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15DILocalVariableD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1952,
   FQN="llvm::DILocalVariable::getImpl", NM="_ZN4llvm15DILocalVariable7getImplERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjjNS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable7getImplERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjjNS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DILocalVariable /*P*/ getImpl(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope,
         StringRef Name, DIFile /*P*/ File, /*uint*/int Line,
         TypedDINodeRef<DIType> Type, /*uint*/int Arg, /*uint*/int Flags,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope,
         Name, File, Line,
         Type, Arg, Flags,
         Storage,
         true);
  }
  private static DILocalVariable /*P*/ getImpl(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope,
         StringRef Name, DIFile /*P*/ File, /*uint*/int Line,
         TypedDINodeRef<DIType> Type, /*uint*/int Arg, /*uint*/int Flags,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Scope, DINode.getCanonicalMDString(Context, new StringRef(Name)), File,
        Line, Type.$Metadata$P(), Arg, Flags, Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 527,
   FQN="llvm::DILocalVariable::getImpl", NM="_ZN4llvm15DILocalVariable7getImplERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jjNS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable7getImplERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jjNS3_11StorageTypeEb")
  //</editor-fold>
  private static DILocalVariable /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope,
         MDString /*P*/ Name, Metadata /*P*/ File,
         /*uint*/int Line, Metadata /*P*/ Type,
         /*uint*/int Arg, /*uint*/int Flags,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope,
         Name, File,
         Line, Type,
         Arg, Flags,
         Storage,
         true);
  }
  private static DILocalVariable /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope,
         MDString /*P*/ Name, Metadata /*P*/ File,
         /*uint*/int Line, Metadata /*P*/ Type,
         /*uint*/int Arg, /*uint*/int Flags,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    // 64K ought to be enough for any frontend.
    assert ($lesseq_uint(Arg, (65535))) : "Expected argument number to fit in 16-bits";
    assert ((Scope != null)) : "Expected scope";
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DILocalVariable /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DILocalVariables, new MDNodeKeyImplDILocalVariable(Scope, Name, File, Line, Type, Arg, Flags));
          if ((N != null)) {
            return N;
          }
        }
        if (!ShouldCreate) {
          return null;
        }
      } else {
        assert (ShouldCreate) : "Expected non-uniqued nodes to always be created";
      }
    } while (false);
    Metadata /*P*/ Ops[/*4*/] = new Metadata /*P*/  [/*4*/] {Scope, Name, File, Type};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DILocalVariable(Context, Storage, Line, Arg, Flags, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DILocalVariables);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1966,
   FQN="llvm::DILocalVariable::cloneImpl", NM="_ZNK4llvm15DILocalVariable9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DILocalVariable9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DILocalVariable /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DILocalVariable.getTemporary(getContext(), getScope(), getName(), getFile(),
        getLine(), getType(), getArg(), getFlags());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1972,
   FQN="llvm::DILocalVariable::get", NM="_ZN4llvm15DILocalVariable3getERNS_11LLVMContextEPNS_12DILocalScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable3getERNS_11LLVMContextEPNS_12DILocalScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjj")
  //</editor-fold>
  public static DILocalVariable /*P*/ get(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type, /*uint*/int Arg, /*uint*/int Flags) {
    return DILocalVariable.getImpl(Context, Scope, new StringRef(Name), File, Line, new TypedDINodeRef<DIType>(Type), Arg, Flags, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1972,
   FQN="llvm::DILocalVariable::getIfExists", NM="_ZN4llvm15DILocalVariable11getIfExistsERNS_11LLVMContextEPNS_12DILocalScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable11getIfExistsERNS_11LLVMContextEPNS_12DILocalScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjj")
  //</editor-fold>
  public static DILocalVariable /*P*/ getIfExists(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type, /*uint*/int Arg, /*uint*/int Flags) {
    return DILocalVariable.getImpl(Context, Scope, new StringRef(Name), File, Line, new TypedDINodeRef<DIType>(Type), Arg, Flags, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1972,
   FQN="llvm::DILocalVariable::getDistinct", NM="_ZN4llvm15DILocalVariable11getDistinctERNS_11LLVMContextEPNS_12DILocalScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable11getDistinctERNS_11LLVMContextEPNS_12DILocalScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjj")
  //</editor-fold>
  public static DILocalVariable /*P*/ getDistinct(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type, /*uint*/int Arg, /*uint*/int Flags) {
    return DILocalVariable.getImpl(Context, Scope, new StringRef(Name), File, Line, new TypedDINodeRef<DIType>(Type), Arg, Flags, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1972,
   FQN="llvm::DILocalVariable::getTemporary", NM="_ZN4llvm15DILocalVariable12getTemporaryERNS_11LLVMContextEPNS_12DILocalScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable12getTemporaryERNS_11LLVMContextEPNS_12DILocalScopeENS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEjj")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DILocalVariable /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type, /*uint*/int Arg, /*uint*/int Flags) {
    return new std.unique_ptr_with_deleter<DILocalVariable /*, TempMDNodeDeleter*/>(DILocalVariable.getImpl(Context, Scope, new StringRef(Name), File, Line, new TypedDINodeRef<DIType>(Type), Arg, Flags, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1977,
   FQN="llvm::DILocalVariable::get", NM="_ZN4llvm15DILocalVariable3getERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable3getERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jj")
  //</editor-fold>
  public static DILocalVariable /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, /*uint*/int Arg, /*uint*/int Flags) {
    return getImpl(Context, Scope, Name, File, Line, Type, Arg, Flags, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1977,
   FQN="llvm::DILocalVariable::getIfExists", NM="_ZN4llvm15DILocalVariable11getIfExistsERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable11getIfExistsERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jj")
  //</editor-fold>
  public static DILocalVariable /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, /*uint*/int Arg, /*uint*/int Flags) {
    return getImpl(Context, Scope, Name, File, Line, Type, Arg, Flags, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1977,
   FQN="llvm::DILocalVariable::getDistinct", NM="_ZN4llvm15DILocalVariable11getDistinctERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable11getDistinctERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jj")
  //</editor-fold>
  public static DILocalVariable /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, /*uint*/int Arg, /*uint*/int Flags) {
    return getImpl(Context, Scope, Name, File, Line, Type, Arg, Flags, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1977,
   FQN="llvm::DILocalVariable::getTemporary", NM="_ZN4llvm15DILocalVariable12getTemporaryERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable12getTemporaryERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES4_jS4_jj")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DILocalVariable /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, /*uint*/int Arg, /*uint*/int Flags) {
    return new std.unique_ptr_with_deleter<DILocalVariable /*, TempMDNodeDeleter*/>(getImpl(Context, Scope, Name, File, Line, Type, Arg, Flags, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1983,
   FQN="llvm::DILocalVariable::clone", NM="_ZNK4llvm15DILocalVariable5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DILocalVariable5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DILocalVariable /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  /// \brief Get the local scope for this variable.
  ///
  /// Variables must be defined in a local scope.
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1988,
   FQN="llvm::DILocalVariable::getScope", NM="_ZNK4llvm15DILocalVariable8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DILocalVariable8getScopeEv")
  //</editor-fold>
  public DILocalScope /*P*/ getScope() /*const*/ {
    return cast_DILocalScope(super.getScope());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::isParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1992,
   FQN="llvm::DILocalVariable::isParameter", NM="_ZNK4llvm15DILocalVariable11isParameterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DILocalVariable11isParameterEv")
  //</editor-fold>
  public boolean isParameter() /*const*/ {
    return ($16bits_uint2uint(Arg) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1993,
   FQN="llvm::DILocalVariable::getArg", NM="_ZNK4llvm15DILocalVariable6getArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DILocalVariable6getArgEv")
  //</editor-fold>
  public /*uint*/int getArg() /*const*/ {
    return $16bits_uint2uint(Arg);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::getFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1994,
   FQN="llvm::DILocalVariable::getFlags", NM="_ZNK4llvm15DILocalVariable8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DILocalVariable8getFlagsEv")
  //</editor-fold>
  public /*uint*/int getFlags() /*const*/ {
    return $16bits_uint2uint(Flags);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::isArtificial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1996,
   FQN="llvm::DILocalVariable::isArtificial", NM="_ZNK4llvm15DILocalVariable12isArtificialEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DILocalVariable12isArtificialEv")
  //</editor-fold>
  public boolean isArtificial() /*const*/ {
    return ((getFlags() & DIFlags.FlagArtificial) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::isObjectPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1997,
   FQN="llvm::DILocalVariable::isObjectPointer", NM="_ZNK4llvm15DILocalVariable15isObjectPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DILocalVariable15isObjectPointerEv")
  //</editor-fold>
  public boolean isObjectPointer() /*const*/ {
    return ((getFlags() & DIFlags.FlagObjectPointer) != 0);
  }


  /// \brief Check that a location is valid for this variable.
  ///
  /// Check that \c DL exists, is in the same subprogram, and has the same
  /// inlined-at location as \c this.  (Otherwise, it's not a valid attachment
  /// to a \a DbgInfoIntrinsic.)
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::isValidLocationForIntrinsic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2004,
   FQN="llvm::DILocalVariable::isValidLocationForIntrinsic", NM="_ZNK4llvm15DILocalVariable27isValidLocationForIntrinsicEPKNS_10DILocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DILocalVariable27isValidLocationForIntrinsicEPKNS_10DILocationE")
  //</editor-fold>
  public boolean isValidLocationForIntrinsic(/*const*/ DILocation /*P*/ DL) /*const*/ {
    return (DL != null) && getScope().getSubprogram() == DL.getScope().getSubprogram();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocalVariable::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2008,
   FQN="llvm::DILocalVariable::classof", NM="_ZN4llvm15DILocalVariable7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DILocalVariable7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DILocalVariableKind.getValue();
  }


  @Override public String toString() {
    return "" + "Arg=" + $ushort2uint(Arg) // NOI18N
              + ", Flags=" + $ushort2uint(Flags) // NOI18N
              + super.toString(); // NOI18N
  }
}
