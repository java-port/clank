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

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;


/// \brief DenseMapInfo for MDNode subclasses.
/*template <class NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::MDNodeInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 939,
 FQN="llvm::MDNodeInfo", NM="_ZN4llvm10MDNodeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm10MDNodeInfoE")
//</editor-fold>
public abstract class/*struct*/ MDNodeInfo</*class*/ NodeTy extends MDNode>  implements DenseMapInfo<NodeTy> {
  // JAVA: typedef MDNodeKeyImpl<NodeTy> KeyTy
//  public final class KeyTy extends MDNodeKeyImpl<NodeTy>{ };
  // JAVA: typedef MDNodeSubsetEqualImpl<NodeTy> SubsetEqualTy
//  public final class SubsetEqualTy extends MDNodeSubsetEqualImpl<NodeTy>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeInfo::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 942,
   FQN="llvm::MDNodeInfo::getEmptyKey", NM="_ZN4llvm10MDNodeInfo11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm10MDNodeInfo11getEmptyKeyEv")
  //</editor-fold>
  @Override
  public /*inline*/ Object /*P*/ getEmptyKey() {
    return DenseMapInfo$LikePtr.$Info().getEmptyKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeInfo::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 945,
   FQN="llvm::MDNodeInfo::getTombstoneKey", NM="_ZN4llvm10MDNodeInfo15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm10MDNodeInfo15getTombstoneKeyEv")
  //</editor-fold>
  @Override
  public Object /*P*/ getTombstoneKey() {
    return DenseMapInfo$LikePtr.$Info().getTombstoneKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeInfo::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 948,
   FQN="llvm::MDNodeInfo::getHashValue", NM="_ZN4llvm10MDNodeInfo12getHashValueERKNS_13MDNodeKeyImplIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm10MDNodeInfo12getHashValueERKNS_13MDNodeKeyImplIT_EE")
  //</editor-fold>
  public /*uint*/int getHashValue(final /*const*/ MDNodeKeyImpl<NodeTy> /*&*/ Key) {
    return Key.getHashValue();
  }

  @Override
  public int getHashValueAlt(Object AltKey) {
    assert AltKey != null;
    return getHashValue((MDNodeKeyImpl)AltKey);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeInfo::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 949,
   FQN="llvm::MDNodeInfo::getHashValue", NM="_ZN4llvm10MDNodeInfo12getHashValueEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm10MDNodeInfo12getHashValueEPKT_")
  //</editor-fold>
  @Override
  public /*uint*/int getHashValue(/*const*/ NodeTy /*P*/ N) {    
    return $getMDNodeKeyImpl(N).getHashValue(); //return MDNodeKeyImpl<NodeTy>(N).getHashValue();
  }
  
  protected abstract MDNodeKeyImpl<NodeTy> $getMDNodeKeyImpl(NodeTy N);

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeInfo::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 952,
   FQN="llvm::MDNodeInfo::isEqual", NM="_ZN4llvm10MDNodeInfo7isEqualERKNS_13MDNodeKeyImplIT_EEPKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm10MDNodeInfo7isEqualERKNS_13MDNodeKeyImplIT_EEPKS2_")
  //</editor-fold>
  @Override
  public boolean isEqualAlt(final /*const*/ Object /*&*/ AltKey, /*const*/ NodeTy /*P*/ RHS) {
    MDNodeKeyImpl<NodeTy> LHS = (MDNodeKeyImpl<NodeTy>) AltKey;
    if (Native.$bool(Native.$eq(RHS, getEmptyKey())) || Native.$bool(Native.$eq(RHS, getTombstoneKey()))) {
      return false;
    }
    return Native.$bool(MDNodeSubsetEqualImpl.<NodeTy>isSubsetEqual(LHS, RHS)) || Native.$bool(LHS.isKeyOf(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeInfo::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 957,
   FQN="llvm::MDNodeInfo::isEqual", NM="_ZN4llvm10MDNodeInfo7isEqualEPKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm10MDNodeInfo7isEqualEPKT_S3_")
  //</editor-fold>
  @Override
  public boolean isEqual(/*const*/ NodeTy /*P*/ LHS, /*const*/ NodeTy /*P*/ RHS) {
    if (Native.$eq(LHS, RHS)) {
      return true;
    }
    if (Native.$bool(Native.$eq(RHS, getEmptyKey())) || Native.$bool(Native.$eq(RHS, getTombstoneKey()))) {
      return false;
    }
    return MDNodeSubsetEqualImpl.<NodeTy>isSubsetEqual(LHS, RHS);
  }
  
  private static final MDNodeInfo<DIBasicType> $Instance$DIBasicType = new MDNodeInfo<DIBasicType>() {
    protected MDNodeKeyImpl<DIBasicType> $getMDNodeKeyImpl(DIBasicType N) {
      return new MDNodeKeyImplDIBasicType(N);
    }
  };
  
  private static final MDNodeInfo<DICompositeType> $Instance$DICompositeType = new MDNodeInfo<DICompositeType>() {
    protected MDNodeKeyImpl<DICompositeType> $getMDNodeKeyImpl(DICompositeType N) {
      return new MDNodeKeyImplDICompositeType(N);
    }
  };

  private static final MDNodeInfo<DIDerivedType> $Instance$DIDerivedType = new MDNodeInfo<DIDerivedType>() {
    protected MDNodeKeyImpl<DIDerivedType> $getMDNodeKeyImpl(DIDerivedType N) {
      return new MDNodeKeyImplDIDerivedType(N);
    }
  };

  private static final MDNodeInfo<DIEnumerator> $Instance$DIEnumerator = new MDNodeInfo<DIEnumerator>() {
    protected MDNodeKeyImpl<DIEnumerator> $getMDNodeKeyImpl(DIEnumerator N) {
      return new MDNodeKeyImplDIEnumerator(N);
    }
  };

  private static final MDNodeInfo<DIExpression> $Instance$DIExpression = new MDNodeInfo<DIExpression>() {
    protected MDNodeKeyImpl<DIExpression> $getMDNodeKeyImpl(DIExpression N) {
      return new MDNodeKeyImplDIExpression(N);
    }
  };

  private static final MDNodeInfo<DIFile> $Instance$DIFile = new MDNodeInfo<DIFile>() {
    protected MDNodeKeyImpl<DIFile> $getMDNodeKeyImpl(DIFile N) {
      return new MDNodeKeyImplDIFile(N);
    }
  };
  
  private static final MDNodeInfo<DIGlobalVariable> $Instance$DIGlobalVariable = new MDNodeInfo<DIGlobalVariable>() {
    protected MDNodeKeyImpl<DIGlobalVariable> $getMDNodeKeyImpl(DIGlobalVariable N) {
      return new MDNodeKeyImplDIGlobalVariable(N);
    }
  };

  private static final MDNodeInfo<DIImportedEntity> $Instance$DIImportedEntity = new MDNodeInfo<DIImportedEntity>() {
    protected MDNodeKeyImpl<DIImportedEntity> $getMDNodeKeyImpl(DIImportedEntity N) {
      return new MDNodeKeyImplDIImportedEntity(N);
    }
  };

  private static final MDNodeInfo<DILexicalBlock> $Instance$DILexicalBlock = new MDNodeInfo<DILexicalBlock>() {
    protected MDNodeKeyImpl<DILexicalBlock> $getMDNodeKeyImpl(DILexicalBlock N) {
      return new MDNodeKeyImplDILexicalBlock(N);
    }
  };

  private static final MDNodeInfo<DILexicalBlockFile> $Instance$DILexicalBlockFile = new MDNodeInfo<DILexicalBlockFile>() {
    protected MDNodeKeyImpl<DILexicalBlockFile> $getMDNodeKeyImpl(DILexicalBlockFile N) {
      return new MDNodeKeyImplDILexicalBlockFile(N);
    }
  };

  private static final MDNodeInfo<DILocalVariable> $Instance$DILocalVariable = new MDNodeInfo<DILocalVariable>() {
    protected MDNodeKeyImpl<DILocalVariable> $getMDNodeKeyImpl(DILocalVariable N) {
      return new MDNodeKeyImplDILocalVariable(N);
    }
  };

  private static final MDNodeInfo<DILocation> $Instance$DILocation = new MDNodeInfo<DILocation>() {
    protected MDNodeKeyImpl<DILocation> $getMDNodeKeyImpl(DILocation N) {
      return new MDNodeKeyImplDILocation(N);
    }
  };

  private static final MDNodeInfo<DIMacro> $Instance$DIMacro = new MDNodeInfo<DIMacro>() {
    protected MDNodeKeyImpl<DIMacro> $getMDNodeKeyImpl(DIMacro N) {
      return new MDNodeKeyImplDIMacro(N);
    }
  };

  private static final MDNodeInfo<DIMacroFile> $Instance$DIMacroFile = new MDNodeInfo<DIMacroFile>() {
    protected MDNodeKeyImpl<DIMacroFile> $getMDNodeKeyImpl(DIMacroFile N) {
      return new MDNodeKeyImplDIMacroFile(N);
    }
  };

  private static final MDNodeInfo<DIModule> $Instance$DIModule = new MDNodeInfo<DIModule>() {
    protected MDNodeKeyImpl<DIModule> $getMDNodeKeyImpl(DIModule N) {
      return new MDNodeKeyImplDIModule(N);
    }
  };

  private static final MDNodeInfo<DINamespace> $Instance$DINamespace = new MDNodeInfo<DINamespace>() {
    protected MDNodeKeyImpl<DINamespace> $getMDNodeKeyImpl(DINamespace N) {
      return new MDNodeKeyImplDINamespace(N);
    }
  };

  private static final MDNodeInfo<DIObjCProperty> $Instance$DIObjCProperty = new MDNodeInfo<DIObjCProperty>() {
    protected MDNodeKeyImpl<DIObjCProperty> $getMDNodeKeyImpl(DIObjCProperty N) {
      return new MDNodeKeyImplDIObjCProperty(N);
    }
  };

  private static final MDNodeInfo<DISubprogram> $Instance$DISubprogram = new MDNodeInfo<DISubprogram>() {
    protected MDNodeKeyImpl<DISubprogram> $getMDNodeKeyImpl(DISubprogram N) {
      return new MDNodeKeyImplDISubprogram(N);
    }
  };

  private static final MDNodeInfo<DISubrange> $Instance$DISubrange = new MDNodeInfo<DISubrange>() {
    protected MDNodeKeyImpl<DISubrange> $getMDNodeKeyImpl(DISubrange N) {
      return new MDNodeKeyImplDISubrange(N);
    }
  };

  private static final MDNodeInfo<DISubroutineType> $Instance$DISubroutineType = new MDNodeInfo<DISubroutineType>() {
    protected MDNodeKeyImpl<DISubroutineType> $getMDNodeKeyImpl(DISubroutineType N) {
      return new MDNodeKeyImplDISubroutineType(N);
    }
  };

  private static final MDNodeInfo<DITemplateTypeParameter> $Instance$DITemplateTypeParameter = new MDNodeInfo<DITemplateTypeParameter>() {
    protected MDNodeKeyImpl<DITemplateTypeParameter> $getMDNodeKeyImpl(DITemplateTypeParameter N) {
      return new MDNodeKeyImplDITemplateTypeParameter(N);
    }
  };

  private static final MDNodeInfo<DITemplateValueParameter> $Instance$DITemplateValueParameter = new MDNodeInfo<DITemplateValueParameter>() {
    protected MDNodeKeyImpl<DITemplateValueParameter> $getMDNodeKeyImpl(DITemplateValueParameter N) {
      return new MDNodeKeyImplDITemplateValueParameter(N);
    }
  };

  private static final MDNodeInfo<GenericDINode> $Instance$GenericDINode = new MDNodeInfo<GenericDINode>() {
    protected MDNodeKeyImpl<GenericDINode> $getMDNodeKeyImpl(GenericDINode N) {
      return new MDNodeKeyImplGenericDINode(N);
    }
  };

  private static final MDNodeInfo<MDTuple> $Instance$MDTuple = new MDNodeInfo<MDTuple>() {
    protected MDNodeKeyImpl<MDTuple> $getMDNodeKeyImpl(MDTuple N) {
      return new MDNodeKeyImplMDTuple(N);
    }
  };

  
  public static MDNodeInfo<MDTuple> $Info$MDTuple() {
    return $Instance$MDTuple;
  }
  
  public static MDNodeInfo<DILocation> $Info$DILocation() {
    return $Instance$DILocation;
  }
  
  public static MDNodeInfo<DIExpression> $Info$DIExpression() {
    return $Instance$DIExpression;
  }
  
  public static MDNodeInfo<GenericDINode> $Info$GenericDINode() {
    return $Instance$GenericDINode;
  }
  
  public static MDNodeInfo<DISubrange> $Info$DISubrange() {
    return $Instance$DISubrange;
  }
  
  public static MDNodeInfo<DIEnumerator> $Info$DIEnumerator() {
    return $Instance$DIEnumerator;
  }
  
  public static MDNodeInfo<DIBasicType> $Info$DIBasicType() {
    return $Instance$DIBasicType;
  }
  
  public static MDNodeInfo<DIDerivedType> $Info$DIDerivedType() {
    return $Instance$DIDerivedType;
  }
  
  public static MDNodeInfo<DICompositeType> $Info$DICompositeType() {
    return $Instance$DICompositeType;
  }
  
  public static MDNodeInfo<DISubroutineType> $Info$DISubroutineType() {
    return $Instance$DISubroutineType;
  }
  
  public static MDNodeInfo<DIFile> $Info$DIFile() {
    return $Instance$DIFile;
  }
  
  public static MDNodeInfo<DISubprogram> $Info$DISubprogram() {
    return $Instance$DISubprogram;
  }
  
  public static MDNodeInfo<DILexicalBlock> $Info$DILexicalBlock() {
    return $Instance$DILexicalBlock;
  }
  
  public static MDNodeInfo<DILexicalBlockFile> $Info$DILexicalBlockFile() {
    return $Instance$DILexicalBlockFile;
  }
  
  public static MDNodeInfo<DINamespace> $Info$DINamespace() {
    return $Instance$DINamespace;
  }
  
  public static MDNodeInfo<DITemplateTypeParameter> $Info$DITemplateTypeParameter() {
    return $Instance$DITemplateTypeParameter;
  }
  
  public static MDNodeInfo<DIModule> $Info$DIModule() {
    return $Instance$DIModule;
  }
  
  public static MDNodeInfo<DITemplateValueParameter> $Info$DITemplateValueParameter() {
    return $Instance$DITemplateValueParameter;
  }
  
  public static MDNodeInfo<DIGlobalVariable> $Info$DIGlobalVariable() {
    return $Instance$DIGlobalVariable;
  }
  
  public static MDNodeInfo<DILocalVariable> $Info$DILocalVariable() {
    return $Instance$DILocalVariable;
  }
  
  public static MDNodeInfo<DIObjCProperty> $Info$DIObjCProperty() {
    return $Instance$DIObjCProperty;
  }
  
  public static MDNodeInfo<DIImportedEntity> $Info$DIImportedEntity() {
    return $Instance$DIImportedEntity;
  }
  
  public static MDNodeInfo<DIMacro> $Info$DIMacro() {
    return $Instance$DIMacro;
  }
  
  public static MDNodeInfo<DIMacroFile> $Info$DIMacroFile() {
    return $Instance$DIMacroFile;
  }

  @Override
  public boolean isKeyPointerLike() {
    return true;
  }

  
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
