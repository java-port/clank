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
import org.llvm.support.dwarf.Tag;


/// \brief A (clang) module that has been imported by the compile unit.
///
//<editor-fold defaultstate="collapsed" desc="llvm::DIModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1651,
 FQN="llvm::DIModule", NM="_ZN4llvm8DIModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModuleE")
//</editor-fold>
public class DIModule extends /*public*/ DIScope implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::DIModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1655,
   FQN="llvm::DIModule::DIModule", NM="_ZN4llvm8DIModuleC1ERNS_11LLVMContextENS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModuleC1ERNS_11LLVMContextENS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIModule(final LLVMContext /*&*/ Context, Metadata.StorageType Storage, ArrayRef<Metadata /*P*/ > Ops) {
    // : DIScope(Context, DIModuleKind, Storage, dwarf::DW_TAG_module, Ops)
    //START JInit
    super(Context, MetadataKind.DIModuleKind.getValue(), Storage, $ushort2uint(Tag.DW_TAG_module), new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::~DIModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1657,
   FQN="llvm::DIModule::~DIModule", NM="_ZN4llvm8DIModuleD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModuleD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy() {
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1659,
   FQN="llvm::DIModule::getImpl", NM="_ZN4llvm8DIModule7getImplERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_NS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule7getImplERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_NS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIModule /*P*/ getImpl(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope,
         StringRef Name, StringRef ConfigurationMacros,
         StringRef IncludePath, StringRef ISysRoot,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope,
         Name, ConfigurationMacros,
         IncludePath, ISysRoot,
         Storage, true);
  }
  private static DIModule /*P*/ getImpl(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope,
         StringRef Name, StringRef ConfigurationMacros,
         StringRef IncludePath, StringRef ISysRoot,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Scope, DINode.getCanonicalMDString(Context, new StringRef(Name)),
        DINode.getCanonicalMDString(Context, new StringRef(ConfigurationMacros)),
        DINode.getCanonicalMDString(Context, new StringRef(IncludePath)),
        DINode.getCanonicalMDString(Context, new StringRef(ISysRoot)),
        Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 477,
   FQN="llvm::DIModule::getImpl", NM="_ZN4llvm8DIModule7getImplERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_NS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule7getImplERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_NS3_11StorageTypeEb")
  //</editor-fold>
  private static DIModule /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope,
         MDString /*P*/ Name, MDString /*P*/ ConfigurationMacros,
         MDString /*P*/ IncludePath, MDString /*P*/ ISysRoot,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope,
         Name, ConfigurationMacros,
         IncludePath, ISysRoot,
         Storage, true);
  }
  private static DIModule /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope,
         MDString /*P*/ Name, MDString /*P*/ ConfigurationMacros,
         MDString /*P*/ IncludePath, MDString /*P*/ ISysRoot,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIModule /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIModules, new MDNodeKeyImplDIModule(Scope, Name, ConfigurationMacros, IncludePath, ISysRoot));
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
    Metadata /*P*/ Ops[/*5*/] = new Metadata /*P*/  [/*5*/] {Scope, Name, ConfigurationMacros, IncludePath, ISysRoot};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIModule(Context, Storage, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIModules);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1674,
   FQN="llvm::DIModule::cloneImpl", NM="_ZNK4llvm8DIModule9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIModule /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIModule.getTemporary(getContext(), getScope(), getName(),
        getConfigurationMacros(), getIncludePath(),
        getISysRoot());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1681,
   FQN="llvm::DIModule::get", NM="_ZN4llvm8DIModule3getERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule3getERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_")
  //</editor-fold>
  public static DIModule /*P*/ get(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name, StringRef ConfigurationMacros, StringRef IncludePath, StringRef ISysRoot) {
    return DIModule.getImpl(Context, Scope, new StringRef(Name), new StringRef(ConfigurationMacros), new StringRef(IncludePath), new StringRef(ISysRoot), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1681,
   FQN="llvm::DIModule::getIfExists", NM="_ZN4llvm8DIModule11getIfExistsERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule11getIfExistsERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_")
  //</editor-fold>
  public static DIModule /*P*/ getIfExists(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name, StringRef ConfigurationMacros, StringRef IncludePath, StringRef ISysRoot) {
    return DIModule.getImpl(Context, Scope, new StringRef(Name), new StringRef(ConfigurationMacros), new StringRef(IncludePath), new StringRef(ISysRoot), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1681,
   FQN="llvm::DIModule::getDistinct", NM="_ZN4llvm8DIModule11getDistinctERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule11getDistinctERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_")
  //</editor-fold>
  public static DIModule /*P*/ getDistinct(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name, StringRef ConfigurationMacros, StringRef IncludePath, StringRef ISysRoot) {
    return DIModule.getImpl(Context, Scope, new StringRef(Name), new StringRef(ConfigurationMacros), new StringRef(IncludePath), new StringRef(ISysRoot), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1681,
   FQN="llvm::DIModule::getTemporary", NM="_ZN4llvm8DIModule12getTemporaryERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule12getTemporaryERNS_11LLVMContextEPNS_7DIScopeENS_9StringRefES5_S5_S5_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIModule /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, StringRef Name, StringRef ConfigurationMacros, StringRef IncludePath, StringRef ISysRoot) {
    return new std.unique_ptr_with_deleter<DIModule /*, TempMDNodeDeleter*/>(DIModule.getImpl(Context, Scope, new StringRef(Name), new StringRef(ConfigurationMacros), new StringRef(IncludePath), new StringRef(ISysRoot), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1685,
   FQN="llvm::DIModule::get", NM="_ZN4llvm8DIModule3getERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule3getERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_")
  //</editor-fold>
  public static DIModule /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ ConfigurationMacros, MDString /*P*/ IncludePath, MDString /*P*/ ISysRoot) {
    return getImpl(Context, Scope, Name, ConfigurationMacros, IncludePath, ISysRoot, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1685,
   FQN="llvm::DIModule::getIfExists", NM="_ZN4llvm8DIModule11getIfExistsERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule11getIfExistsERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_")
  //</editor-fold>
  public static DIModule /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ ConfigurationMacros, MDString /*P*/ IncludePath, MDString /*P*/ ISysRoot) {
    return getImpl(Context, Scope, Name, ConfigurationMacros, IncludePath, ISysRoot, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1685,
   FQN="llvm::DIModule::getDistinct", NM="_ZN4llvm8DIModule11getDistinctERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule11getDistinctERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_")
  //</editor-fold>
  public static DIModule /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ ConfigurationMacros, MDString /*P*/ IncludePath, MDString /*P*/ ISysRoot) {
    return getImpl(Context, Scope, Name, ConfigurationMacros, IncludePath, ISysRoot, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1685,
   FQN="llvm::DIModule::getTemporary", NM="_ZN4llvm8DIModule12getTemporaryERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule12getTemporaryERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S6_S6_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIModule /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ ConfigurationMacros, MDString /*P*/ IncludePath, MDString /*P*/ ISysRoot) {
    return new std.unique_ptr_with_deleter<DIModule /*, TempMDNodeDeleter*/>(getImpl(Context, Scope, Name, ConfigurationMacros, IncludePath, ISysRoot, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1690,
   FQN="llvm::DIModule::clone", NM="_ZNK4llvm8DIModule5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIModule /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1692,
   FQN="llvm::DIModule::getScope", NM="_ZNK4llvm8DIModule8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule8getScopeEv")
  //</editor-fold>
  public DIScope /*P*/ getScope() /*const*/ {
    return cast_or_null_DIScope(getRawScope());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1693,
   FQN="llvm::DIModule::getName", NM="_ZNK4llvm8DIModule7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getStringOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getConfigurationMacros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1694,
   FQN="llvm::DIModule::getConfigurationMacros", NM="_ZNK4llvm8DIModule22getConfigurationMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule22getConfigurationMacrosEv")
  //</editor-fold>
  public StringRef getConfigurationMacros() /*const*/ {
    return getStringOperand(2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getIncludePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1695,
   FQN="llvm::DIModule::getIncludePath", NM="_ZNK4llvm8DIModule14getIncludePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule14getIncludePathEv")
  //</editor-fold>
  public StringRef getIncludePath() /*const*/ {
    return getStringOperand(3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getISysRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1696,
   FQN="llvm::DIModule::getISysRoot", NM="_ZNK4llvm8DIModule11getISysRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule11getISysRootEv")
  //</editor-fold>
  public StringRef getISysRoot() /*const*/ {
    return getStringOperand(4);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getRawScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1698,
   FQN="llvm::DIModule::getRawScope", NM="_ZNK4llvm8DIModule11getRawScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule11getRawScopeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawScope() /*const*/ {
    return getOperand(0).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getRawName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1699,
   FQN="llvm::DIModule::getRawName", NM="_ZNK4llvm8DIModule10getRawNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule10getRawNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getRawConfigurationMacros">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1700,
   FQN="llvm::DIModule::getRawConfigurationMacros", NM="_ZNK4llvm8DIModule25getRawConfigurationMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule25getRawConfigurationMacrosEv")
  //</editor-fold>
  public MDString /*P*/ getRawConfigurationMacros() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getRawIncludePath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1701,
   FQN="llvm::DIModule::getRawIncludePath", NM="_ZNK4llvm8DIModule17getRawIncludePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule17getRawIncludePathEv")
  //</editor-fold>
  public MDString /*P*/ getRawIncludePath() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::getRawISysRoot">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1702,
   FQN="llvm::DIModule::getRawISysRoot", NM="_ZNK4llvm8DIModule14getRawISysRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm8DIModule14getRawISysRootEv")
  //</editor-fold>
  public MDString /*P*/ getRawISysRoot() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 4);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIModule::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1704,
   FQN="llvm::DIModule::classof", NM="_ZN4llvm8DIModule7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm8DIModule7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIModuleKind.getValue();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
