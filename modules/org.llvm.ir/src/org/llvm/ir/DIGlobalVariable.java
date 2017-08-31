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
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Global variables.
///
/// TODO: Remove DisplayName.  It's always equal to Name.
//<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1853,
 FQN="llvm::DIGlobalVariable", NM="_ZN4llvm16DIGlobalVariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariableE")
//</editor-fold>
public class DIGlobalVariable extends /*public*/ DIVariable implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private boolean IsLocalToUnit;
  private boolean IsDefinition;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::DIGlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1860,
   FQN="llvm::DIGlobalVariable::DIGlobalVariable", NM="_ZN4llvm16DIGlobalVariableC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjbbNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariableC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjbbNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIGlobalVariable(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Line,
      boolean IsLocalToUnit, boolean IsDefinition,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DIVariable(C, DIGlobalVariableKind, Storage, Line, Ops), IsLocalToUnit(IsLocalToUnit), IsDefinition(IsDefinition)
    //START JInit
    super(C, MetadataKind.DIGlobalVariableKind.getValue(), Storage, Line, new ArrayRef<Metadata /*P*/ >(Ops));
    this.IsLocalToUnit = IsLocalToUnit;
    this.IsDefinition = IsDefinition;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::~DIGlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1865,
   FQN="llvm::DIGlobalVariable::~DIGlobalVariable", NM="_ZN4llvm16DIGlobalVariableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16DIGlobalVariableD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1867,
   FQN="llvm::DIGlobalVariable::getImpl", NM="_ZN4llvm16DIGlobalVariable7getImplERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable7getImplERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIGlobalVariable /*P*/ getImpl(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name,
         StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type,
         boolean IsLocalToUnit, boolean IsDefinition, Constant /*P*/ Variable,
         DIDerivedType /*P*/ StaticDataMemberDeclaration, Metadata.StorageType Storage) {
    return getImpl(Context, Scope, Name,
         LinkageName, File, Line, Type,
         IsLocalToUnit, IsDefinition, Variable,
         StaticDataMemberDeclaration, Storage,
         true);
  }
  private static DIGlobalVariable /*P*/ getImpl(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name,
         StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type,
         boolean IsLocalToUnit, boolean IsDefinition, Constant /*P*/ Variable,
         DIDerivedType /*P*/ StaticDataMemberDeclaration, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Scope, DINode.getCanonicalMDString(Context, new StringRef(Name)),
        DINode.getCanonicalMDString(Context, new StringRef(LinkageName)), File, Line, Type.$Metadata$P(),
        IsLocalToUnit, IsDefinition,
        (Variable != null) ? ConstantAsMetadata.get(Variable) : (ConstantAsMetadata /*P*/ )null,
        StaticDataMemberDeclaration, Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 508,
   FQN="llvm::DIGlobalVariable::getImpl", NM="_ZN4llvm16DIGlobalVariable7getImplERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_NS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable7getImplERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_NS3_11StorageTypeEb")
  //</editor-fold>
  private static DIGlobalVariable /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name,
         MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line,
         Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition,
         Metadata /*P*/ Variable,
         Metadata /*P*/ StaticDataMemberDeclaration,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope, Name,
         LinkageName, File, Line,
         Type, IsLocalToUnit, IsDefinition,
         Variable,
         StaticDataMemberDeclaration,
         Storage, true);
  }
  private static DIGlobalVariable /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name,
         MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line,
         Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition,
         Metadata /*P*/ Variable,
         Metadata /*P*/ StaticDataMemberDeclaration,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    assert (DebugInfoMetadataStatics.isCanonical(LinkageName)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIGlobalVariable /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIGlobalVariables, new MDNodeKeyImplDIGlobalVariable(Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, Variable, StaticDataMemberDeclaration));
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
    Metadata /*P*/ Ops[/*8*/] = new Metadata /*P*/  [/*8*/] {
      Scope, Name, File, Type,
      Name, LinkageName, Variable, StaticDataMemberDeclaration};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIGlobalVariable(Context, Storage, Line, IsLocalToUnit, IsDefinition, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIGlobalVariables);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1886,
   FQN="llvm::DIGlobalVariable::cloneImpl", NM="_ZNK4llvm16DIGlobalVariable9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIGlobalVariable /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIGlobalVariable.getTemporary(getContext(), getScope(), getName(), getLinkageName(),
        getFile(), getLine(), getType(), isLocalToUnit(),
        isDefinition(), getVariable(),
        getStaticDataMemberDeclaration());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1894,
   FQN="llvm::DIGlobalVariable::get", NM="_ZN4llvm16DIGlobalVariable3getERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable3getERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeE")
  //</editor-fold>
  public static DIGlobalVariable /*P*/ get(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type, boolean IsLocalToUnit, boolean IsDefinition, Constant /*P*/ Variable, DIDerivedType /*P*/ StaticDataMemberDeclaration) {
    return DIGlobalVariable.getImpl(Context, Scope, new StringRef(Name), new StringRef(LinkageName), File, Line, new TypedDINodeRef<DIType>(Type), IsLocalToUnit, IsDefinition, Variable, StaticDataMemberDeclaration, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1894,
   FQN="llvm::DIGlobalVariable::getIfExists", NM="_ZN4llvm16DIGlobalVariable11getIfExistsERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable11getIfExistsERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeE")
  //</editor-fold>
  public static DIGlobalVariable /*P*/ getIfExists(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type, boolean IsLocalToUnit, boolean IsDefinition, Constant /*P*/ Variable, DIDerivedType /*P*/ StaticDataMemberDeclaration) {
    return DIGlobalVariable.getImpl(Context, Scope, new StringRef(Name), new StringRef(LinkageName), File, Line, new TypedDINodeRef<DIType>(Type), IsLocalToUnit, IsDefinition, Variable, StaticDataMemberDeclaration, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1894,
   FQN="llvm::DIGlobalVariable::getDistinct", NM="_ZN4llvm16DIGlobalVariable11getDistinctERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable11getDistinctERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeE")
  //</editor-fold>
  public static DIGlobalVariable /*P*/ getDistinct(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type, boolean IsLocalToUnit, boolean IsDefinition, Constant /*P*/ Variable, DIDerivedType /*P*/ StaticDataMemberDeclaration) {
    return DIGlobalVariable.getImpl(Context, Scope, new StringRef(Name), new StringRef(LinkageName), File, Line, new TypedDINodeRef<DIType>(Type), IsLocalToUnit, IsDefinition, Variable, StaticDataMemberDeclaration, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1894,
   FQN="llvm::DIGlobalVariable::getTemporary", NM="_ZN4llvm16DIGlobalVariable12getTemporaryERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable12getTemporaryERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_PNS_6DIFileEjNS_14TypedDINodeRefINS_6DITypeEEEbbPNS_8ConstantEPNS_13DIDerivedTypeE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIGlobalVariable /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIType> Type, boolean IsLocalToUnit, boolean IsDefinition, Constant /*P*/ Variable, DIDerivedType /*P*/ StaticDataMemberDeclaration) {
    return new std.unique_ptr_with_deleter<DIGlobalVariable /*, TempMDNodeDeleter*/>(DIGlobalVariable.getImpl(Context, Scope, new StringRef(Name), new StringRef(LinkageName), File, Line, new TypedDINodeRef<DIType>(Type), IsLocalToUnit, IsDefinition, Variable, StaticDataMemberDeclaration, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1901,
   FQN="llvm::DIGlobalVariable::get", NM="_ZN4llvm16DIGlobalVariable3getERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable3getERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_")
  //</editor-fold>
  public static DIGlobalVariable /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, Metadata /*P*/ Variable, Metadata /*P*/ StaticDataMemberDeclaration) {
    return getImpl(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, Variable, StaticDataMemberDeclaration, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1901,
   FQN="llvm::DIGlobalVariable::getIfExists", NM="_ZN4llvm16DIGlobalVariable11getIfExistsERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable11getIfExistsERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_")
  //</editor-fold>
  public static DIGlobalVariable /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, Metadata /*P*/ Variable, Metadata /*P*/ StaticDataMemberDeclaration) {
    return getImpl(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, Variable, StaticDataMemberDeclaration, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1901,
   FQN="llvm::DIGlobalVariable::getDistinct", NM="_ZN4llvm16DIGlobalVariable11getDistinctERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable11getDistinctERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_")
  //</editor-fold>
  public static DIGlobalVariable /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, Metadata /*P*/ Variable, Metadata /*P*/ StaticDataMemberDeclaration) {
    return getImpl(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, Variable, StaticDataMemberDeclaration, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1901,
   FQN="llvm::DIGlobalVariable::getTemporary", NM="_ZN4llvm16DIGlobalVariable12getTemporaryERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable12getTemporaryERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIGlobalVariable /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, Metadata /*P*/ Variable, Metadata /*P*/ StaticDataMemberDeclaration) {
    return new std.unique_ptr_with_deleter<DIGlobalVariable /*, TempMDNodeDeleter*/>(getImpl(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, Variable, StaticDataMemberDeclaration, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1909,
   FQN="llvm::DIGlobalVariable::clone", NM="_ZNK4llvm16DIGlobalVariable5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIGlobalVariable /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::isLocalToUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1911,
   FQN="llvm::DIGlobalVariable::isLocalToUnit", NM="_ZNK4llvm16DIGlobalVariable13isLocalToUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable13isLocalToUnitEv")
  //</editor-fold>
  public boolean isLocalToUnit() /*const*/ {
    return IsLocalToUnit;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::isDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1912,
   FQN="llvm::DIGlobalVariable::isDefinition", NM="_ZNK4llvm16DIGlobalVariable12isDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable12isDefinitionEv")
  //</editor-fold>
  public boolean isDefinition() /*const*/ {
    return IsDefinition;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getDisplayName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1913,
   FQN="llvm::DIGlobalVariable::getDisplayName", NM="_ZNK4llvm16DIGlobalVariable14getDisplayNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable14getDisplayNameEv")
  //</editor-fold>
  public StringRef getDisplayName() /*const*/ {
    return getStringOperand(4);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getLinkageName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1914,
   FQN="llvm::DIGlobalVariable::getLinkageName", NM="_ZNK4llvm16DIGlobalVariable14getLinkageNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable14getLinkageNameEv")
  //</editor-fold>
  public StringRef getLinkageName() /*const*/ {
    return getStringOperand(5);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1915,
   FQN="llvm::DIGlobalVariable::getVariable", NM="_ZNK4llvm16DIGlobalVariable11getVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable11getVariableEv")
  //</editor-fold>
  public Constant /*P*/ getVariable() /*const*/ {
    {
      ConstantAsMetadata /*P*/ C = cast_or_null_ConstantAsMetadata(getRawVariable());
      if ((C != null)) {
        return dyn_cast_Constant(C.getValue());
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getStaticDataMemberDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1920,
   FQN="llvm::DIGlobalVariable::getStaticDataMemberDeclaration", NM="_ZNK4llvm16DIGlobalVariable30getStaticDataMemberDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable30getStaticDataMemberDeclarationEv")
  //</editor-fold>
  public DIDerivedType /*P*/ getStaticDataMemberDeclaration() /*const*/ {
    return cast_or_null_DIDerivedType(getRawStaticDataMemberDeclaration());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getRawLinkageName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1924,
   FQN="llvm::DIGlobalVariable::getRawLinkageName", NM="_ZNK4llvm16DIGlobalVariable17getRawLinkageNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable17getRawLinkageNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawLinkageName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 5);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getRawVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1925,
   FQN="llvm::DIGlobalVariable::getRawVariable", NM="_ZNK4llvm16DIGlobalVariable14getRawVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable14getRawVariableEv")
  //</editor-fold>
  public Metadata /*P*/ getRawVariable() /*const*/ {
    return getOperand(6).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::getRawStaticDataMemberDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1926,
   FQN="llvm::DIGlobalVariable::getRawStaticDataMemberDeclaration", NM="_ZNK4llvm16DIGlobalVariable33getRawStaticDataMemberDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIGlobalVariable33getRawStaticDataMemberDeclarationEv")
  //</editor-fold>
  public Metadata /*P*/ getRawStaticDataMemberDeclaration() /*const*/ {
    return getOperand(7).$Metadata$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIGlobalVariable::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1928,
   FQN="llvm::DIGlobalVariable::classof", NM="_ZN4llvm16DIGlobalVariable7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIGlobalVariable7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIGlobalVariableKind.getValue();
  }


  @Override public String toString() {
    return "" + "IsLocalToUnit=" + IsLocalToUnit // NOI18N
              + ", IsDefinition=" + IsDefinition // NOI18N
              + super.toString(); // NOI18N
  }
}
