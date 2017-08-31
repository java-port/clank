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

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Utility to find all debug info in a module.
///
/// DebugInfoFinder tries to list all debug info MDNodes used in a module. To
/// list debug info MDNodes used by an instruction, DebugInfoFinder uses
/// processDeclare, processValue and processLocation to handle DbgDeclareInst,
/// DbgValueInst and DbgLoc attached to instructions. processModule will go
/// through all DICompileUnits in llvm.dbg.cu and list debug info MDNodes
/// used by the CUs.
//<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 58,
 FQN="llvm::DebugInfoFinder", NM="_ZN4llvm15DebugInfoFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinderE")
//</editor-fold>
public class DebugInfoFinder implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Process entire module and collect debug info anchors.
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::processModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 53,
   FQN="llvm::DebugInfoFinder::processModule", NM="_ZN4llvm15DebugInfoFinder13processModuleERKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder13processModuleERKNS_6ModuleE")
  //</editor-fold>
  public void processModule(final /*const*/ Module /*&*/ M) {
    for (DICompileUnit /*P*/ CU : M.debug_compile_units()) {
      addCompileUnit(CU);
      for (DIGlobalVariable /*P*/ DIG : CU.getGlobalVariables()) {
        if (addGlobalVariable(DIG)) {
          processScope(DIG.getScope());
          processType(DIG.getType().resolve());
        }
      }
      for (DICompositeType /*P*/ ET : CU.getEnumTypes())  {
        processType(ET);
      }
      for (DIScope /*P*/ RT : CU.getRetainedTypes())  {
        {
          DIType /*P*/ T = dyn_cast_DIType(RT);
          if ((T != null)) {
            processType(T);
          } else {
            processSubprogram(cast_DISubprogram(RT));
          }
        }
      }
      for (DIImportedEntity /*P*/ Import : CU.getImportedEntities()) {
        DINode /*P*/ Entity = Import.getEntity().resolve();
        {
          DIType /*P*/ T = dyn_cast_DIType(Entity);
          if ((T != null)) {
            processType(T);
          } else {
            DISubprogram /*P*/ SP = dyn_cast_DISubprogram(Entity);
            if ((SP != null)) {
              processSubprogram(SP);
            } else {
              DINamespace /*P*/ NS = dyn_cast_DINamespace(Entity);
              if ((NS != null)) {
                processScope(NS.getScope());
              } else {
                DIModule /*P*/ M$1 = dyn_cast_DIModule(Entity);
                if ((M$1 != null)) {
                  processScope(M$1.getScope());
                }
              }
            }
          }
        }
      }
    }
    for (final /*const*/ Function /*&*/ F : M.functions$Const())  {
      {
        DISubprogram /*P*/ SP = cast_or_null_DISubprogram(F.getSubprogram());
        if ((SP != null)) {
          processSubprogram(SP);
        }
      }
    }
  }


  /// \brief Process DbgDeclareInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::processDeclare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 157,
   FQN="llvm::DebugInfoFinder::processDeclare", NM="_ZN4llvm15DebugInfoFinder14processDeclareERKNS_6ModuleEPKNS_14DbgDeclareInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder14processDeclareERKNS_6ModuleEPKNS_14DbgDeclareInstE")
  //</editor-fold>
  public void processDeclare(final /*const*/ Module /*&*/ M,
                /*const*/ DbgDeclareInst /*P*/ DDI) {
    MDNode /*P*/ N = dyn_cast_MDNode(DDI.getVariable());
    if (!(N != null)) {
      return;
    }

    DILocalVariable /*P*/ DV = dyn_cast_DILocalVariable(N);
    if (!(DV != null)) {
      return;
    }
    if (!NodesSeen.insert(DV).second) {
      return;
    }
    processScope(DV.getScope());
    processType(DV.getType().resolve());
  }

  /// \brief Process DbgValueInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::processValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 173,
   FQN="llvm::DebugInfoFinder::processValue", NM="_ZN4llvm15DebugInfoFinder12processValueERKNS_6ModuleEPKNS_12DbgValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder12processValueERKNS_6ModuleEPKNS_12DbgValueInstE")
  //</editor-fold>
  public void processValue(final /*const*/ Module /*&*/ M, /*const*/ DbgValueInst /*P*/ DVI) {
    MDNode /*P*/ N = dyn_cast_MDNode(DVI.getVariable());
    if (!(N != null)) {
      return;
    }

    DILocalVariable /*P*/ DV = dyn_cast_DILocalVariable(N);
    if (!(DV != null)) {
      return;
    }
    if (!NodesSeen.insert(DV).second) {
      return;
    }
    processScope(DV.getScope());
    processType(DV.getType().resolve());
  }

  /// \brief Process debug info location.
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::processLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 86,
   FQN="llvm::DebugInfoFinder::processLocation", NM="_ZN4llvm15DebugInfoFinder15processLocationERKNS_6ModuleEPKNS_10DILocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder15processLocationERKNS_6ModuleEPKNS_10DILocationE")
  //</editor-fold>
  public void processLocation(final /*const*/ Module /*&*/ M, /*const*/ DILocation /*P*/ Loc) {
    if (!(Loc != null)) {
      return;
    }
    processScope(Loc.getScope());
    processLocation(M, Loc.getInlinedAt());
  }


  /// \brief Clear all lists.

  //===----------------------------------------------------------------------===//
  // DebugInfoFinder implementations.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 44,
   FQN="llvm::DebugInfoFinder::reset", NM="_ZN4llvm15DebugInfoFinder5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder5resetEv")
  //</editor-fold>
  public void reset() {
    CUs.clear();
    SPs.clear();
    GVs.clear();
    TYs.clear();
    Scopes.clear();
    NodesSeen.clear();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::InitializeTypeMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 74,
   FQN="llvm::DebugInfoFinder::InitializeTypeMap", NM="_ZN4llvm15DebugInfoFinder17InitializeTypeMapERKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder17InitializeTypeMapERKNS_6ModuleE")
  //</editor-fold>
  private void InitializeTypeMap(final /*const*/ Module /*&*/ M) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::processType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 93,
   FQN="llvm::DebugInfoFinder::processType", NM="_ZN4llvm15DebugInfoFinder11processTypeEPNS_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder11processTypeEPNS_6DITypeE")
  //</editor-fold>
  private void processType(DIType /*P*/ DT) {
    if (!addType(DT)) {
      return;
    }
    processScope(DT.getScope().resolve());
    {
      DISubroutineType /*P*/ ST = dyn_cast_DISubroutineType(DT);
      if ((ST != null)) {
        for (TypedDINodeRef<DIType> Ref : ST.getTypeArray())  {
          processType(Ref.resolve());
        }
        return;
      }
    }
    {
      DICompositeType /*P*/ DCT = dyn_cast_DICompositeType(DT);
      if ((DCT != null)) {
        processType(DCT.getBaseType().resolve());
        for (Metadata /*P*/ D : DCT.getElements()) {
          {
            DIType /*P*/ T = dyn_cast_DIType(D);
            if ((T != null)) {
              processType(T);
            } else {
              DISubprogram /*P*/ SP = dyn_cast_DISubprogram(D);
              if ((SP != null)) {
                processSubprogram(SP);
              }
            }
          }
        }
        return;
      }
    }
    {
      DIDerivedType /*P*/ DDT = dyn_cast_DIDerivedType(DT);
      if ((DDT != null)) {
        processType(DDT.getBaseType().resolve());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::processSubprogram">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 143,
   FQN="llvm::DebugInfoFinder::processSubprogram", NM="_ZN4llvm15DebugInfoFinder17processSubprogramEPNS_12DISubprogramE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder17processSubprogramEPNS_12DISubprogramE")
  //</editor-fold>
  private void processSubprogram(DISubprogram /*P*/ SP) {
    if (!addSubprogram(SP)) {
      return;
    }
    processScope(SP.getScope().resolve());
    processType(SP.getType());
    for (DITemplateParameter /*P*/ Element : SP.getTemplateParams()) {
      {
        DITemplateTypeParameter /*P*/ TType = dyn_cast_DITemplateTypeParameter(Element);
        if ((TType != null)) {
          processType(TType.getType().resolve());
        } else {
          DITemplateValueParameter /*P*/ TVal = dyn_cast_DITemplateValueParameter(Element);
          if ((TVal != null)) {
            processType(TVal.getType().resolve());
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::processScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 117,
   FQN="llvm::DebugInfoFinder::processScope", NM="_ZN4llvm15DebugInfoFinder12processScopeEPNS_7DIScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder12processScopeEPNS_7DIScopeE")
  //</editor-fold>
  private void processScope(DIScope /*P*/ Scope) {
    if (!(Scope != null)) {
      return;
    }
    {
      DIType /*P*/ Ty = dyn_cast_DIType(Scope);
      if ((Ty != null)) {
        processType(Ty);
        return;
      }
    }
    {
      DICompileUnit /*P*/ CU = dyn_cast_DICompileUnit(Scope);
      if ((CU != null)) {
        addCompileUnit(CU);
        return;
      }
    }
    {
      DISubprogram /*P*/ SP = dyn_cast_DISubprogram(Scope);
      if ((SP != null)) {
        processSubprogram(SP);
        return;
      }
    }
    if (!addScope(Scope)) {
      return;
    }
    {
      DILexicalBlockBase /*P*/ LB = dyn_cast_DILexicalBlockBase(Scope);
      if ((LB != null)) {
        processScope(LB.getScope());
      } else {
        DINamespace /*P*/ NS = dyn_cast_DINamespace(Scope);
        if ((NS != null)) {
          processScope(NS.getScope());
        } else {
          DIModule /*P*/ M = dyn_cast_DIModule(Scope);
          if ((M != null)) {
            processScope(M.getScope());
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::addCompileUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 199,
   FQN="llvm::DebugInfoFinder::addCompileUnit", NM="_ZN4llvm15DebugInfoFinder14addCompileUnitEPNS_13DICompileUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder14addCompileUnitEPNS_13DICompileUnitE")
  //</editor-fold>
  private boolean addCompileUnit(DICompileUnit /*P*/ CU) {
    if (!(CU != null)) {
      return false;
    }
    if (!NodesSeen.insert(CU).second) {
      return false;
    }

    CUs.push_back(CU);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::addGlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 209,
   FQN="llvm::DebugInfoFinder::addGlobalVariable", NM="_ZN4llvm15DebugInfoFinder17addGlobalVariableEPNS_16DIGlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder17addGlobalVariableEPNS_16DIGlobalVariableE")
  //</editor-fold>
  private boolean addGlobalVariable(DIGlobalVariable /*P*/ DIG) {
    if (!(DIG != null)) {
      return false;
    }
    if (!NodesSeen.insert(DIG).second) {
      return false;
    }

    GVs.push_back(DIG);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::addSubprogram">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 220,
   FQN="llvm::DebugInfoFinder::addSubprogram", NM="_ZN4llvm15DebugInfoFinder13addSubprogramEPNS_12DISubprogramE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder13addSubprogramEPNS_12DISubprogramE")
  //</editor-fold>
  private boolean addSubprogram(DISubprogram /*P*/ SP) {
    if (!(SP != null)) {
      return false;
    }
    if (!NodesSeen.insert(SP).second) {
      return false;
    }

    SPs.push_back(SP);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::addType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 188,
   FQN="llvm::DebugInfoFinder::addType", NM="_ZN4llvm15DebugInfoFinder7addTypeEPNS_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder7addTypeEPNS_6DITypeE")
  //</editor-fold>
  private boolean addType(DIType /*P*/ DT) {
    if (!(DT != null)) {
      return false;
    }
    if (!NodesSeen.insert(DT).second) {
      return false;
    }

    TYs.push_back(((/*const_cast*/DIType /*P*/ )(DT)));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::addScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 231,
   FQN="llvm::DebugInfoFinder::addScope", NM="_ZN4llvm15DebugInfoFinder8addScopeEPNS_7DIScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15DebugInfoFinder8addScopeEPNS_7DIScopeE")
  //</editor-fold>
  private boolean addScope(DIScope /*P*/ Scope) {
    if (!(Scope != null)) {
      return false;
    }
    // FIXME: Ocaml binding generates a scope with no content, we treat it
    // as null for now.
    if (Scope.getNumOperands() == 0) {
      return false;
    }
    if (!NodesSeen.insert(Scope).second) {
      return false;
    }
    Scopes.push_back(Scope);
    return true;
  }

/*public:*/
  // JAVA: typedef SmallVectorImpl<DICompileUnit *>::const_iterator compile_unit_iterator
//  public final class compile_unit_iterator extends type$ptr<DICompileUnit /*P*/ /*P*/>{ };
  // JAVA: typedef SmallVectorImpl<DISubprogram *>::const_iterator subprogram_iterator
//  public final class subprogram_iterator extends type$ptr<DISubprogram /*P*/ /*P*/>{ };
  // JAVA: typedef SmallVectorImpl<DIGlobalVariable *>::const_iterator global_variable_iterator
//  public final class global_variable_iterator extends type$ptr<DIGlobalVariable /*P*/ /*P*/>{ };
  // JAVA: typedef SmallVectorImpl<DIType *>::const_iterator type_iterator
//  public final class type_iterator extends type$ptr<DIType /*P*/ /*P*/>{ };
  // JAVA: typedef SmallVectorImpl<DIScope *>::const_iterator scope_iterator
//  public final class scope_iterator extends type$ptr<DIScope /*P*/ /*P*/>{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::compile_units">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 94,
   FQN="llvm::DebugInfoFinder::compile_units", NM="_ZNK4llvm15DebugInfoFinder13compile_unitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder13compile_unitsEv")
  //</editor-fold>
  public iterator_range<DICompileUnit /*P*/ /*const*/> compile_units() /*const*/ {
    return make_range(CUs.begin$Const(), CUs.end$Const());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::subprograms">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 98,
   FQN="llvm::DebugInfoFinder::subprograms", NM="_ZNK4llvm15DebugInfoFinder11subprogramsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder11subprogramsEv")
  //</editor-fold>
  public iterator_range<DISubprogram /*P*/ /*const*/> subprograms() /*const*/ {
    return make_range(SPs.begin$Const(), SPs.end$Const());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::global_variables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 102,
   FQN="llvm::DebugInfoFinder::global_variables", NM="_ZNK4llvm15DebugInfoFinder16global_variablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder16global_variablesEv")
  //</editor-fold>
  public iterator_range<DIGlobalVariable /*P*/ /*const*/> global_variables() /*const*/ {
    return make_range(GVs.begin$Const(), GVs.end$Const());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::types">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 106,
   FQN="llvm::DebugInfoFinder::types", NM="_ZNK4llvm15DebugInfoFinder5typesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder5typesEv")
  //</editor-fold>
  public iterator_range<DIType /*P*/ /*const*/> types() /*const*/ {
    return make_range(TYs.begin$Const(), TYs.end$Const());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::scopes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 110,
   FQN="llvm::DebugInfoFinder::scopes", NM="_ZNK4llvm15DebugInfoFinder6scopesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder6scopesEv")
  //</editor-fold>
  public iterator_range<DIScope /*P*/ /*const*/> scopes() /*const*/ {
    return make_range(Scopes.begin$Const(), Scopes.end$Const());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::compile_unit_count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 114,
   FQN="llvm::DebugInfoFinder::compile_unit_count", NM="_ZNK4llvm15DebugInfoFinder18compile_unit_countEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder18compile_unit_countEv")
  //</editor-fold>
  public /*uint*/int compile_unit_count() /*const*/ {
    return CUs.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::global_variable_count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 115,
   FQN="llvm::DebugInfoFinder::global_variable_count", NM="_ZNK4llvm15DebugInfoFinder21global_variable_countEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder21global_variable_countEv")
  //</editor-fold>
  public /*uint*/int global_variable_count() /*const*/ {
    return GVs.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::subprogram_count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 116,
   FQN="llvm::DebugInfoFinder::subprogram_count", NM="_ZNK4llvm15DebugInfoFinder16subprogram_countEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder16subprogram_countEv")
  //</editor-fold>
  public /*uint*/int subprogram_count() /*const*/ {
    return SPs.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::type_count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 117,
   FQN="llvm::DebugInfoFinder::type_count", NM="_ZNK4llvm15DebugInfoFinder10type_countEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder10type_countEv")
  //</editor-fold>
  public /*uint*/int type_count() /*const*/ {
    return TYs.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::scope_count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 118,
   FQN="llvm::DebugInfoFinder::scope_count", NM="_ZNK4llvm15DebugInfoFinder11scope_countEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZNK4llvm15DebugInfoFinder11scope_countEv")
  //</editor-fold>
  public /*uint*/int scope_count() /*const*/ {
    return Scopes.size();
  }

/*private:*/
  private SmallVector<DICompileUnit /*P*/ > CUs;
  private SmallVector<DISubprogram /*P*/ > SPs;
  private SmallVector<DIGlobalVariable /*P*/ > GVs;
  private SmallVector<DIType /*P*/ > TYs;
  private SmallVector<DIScope /*P*/ > Scopes;
  private SmallPtrSet</*const*/ MDNode /*P*/ > NodesSeen;

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::DebugInfoFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 58,
   FQN="llvm::DebugInfoFinder::DebugInfoFinder", NM="_ZN4llvm15DebugInfoFinderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm15DebugInfoFinderC1Ev")
  //</editor-fold>
  public /*inline*/ DebugInfoFinder() {
    // : CUs(), SPs(), GVs(), TYs(), Scopes(), NodesSeen()
    //START JInit
    this.CUs = new SmallVector<DICompileUnit /*P*/ >(8, (DICompileUnit /*P*/ )null);
    this.SPs = new SmallVector<DISubprogram /*P*/ >(8, (DISubprogram /*P*/ )null);
    this.GVs = new SmallVector<DIGlobalVariable /*P*/ >(8, (DIGlobalVariable /*P*/ )null);
    this.TYs = new SmallVector<DIType /*P*/ >(8, (DIType /*P*/ )null);
    this.Scopes = new SmallVector<DIScope /*P*/ >(8, (DIScope /*P*/ )null);
    this.NodesSeen = new SmallPtrSet</*const*/ MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DebugInfoFinder::~DebugInfoFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 58,
   FQN="llvm::DebugInfoFinder::~DebugInfoFinder", NM="_ZN4llvm15DebugInfoFinderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm15DebugInfoFinderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    NodesSeen.$destroy();
    Scopes.$destroy();
    TYs.$destroy();
    GVs.$destroy();
    SPs.$destroy();
    CUs.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "CUs=" + CUs // NOI18N
              + ", SPs=" + SPs // NOI18N
              + ", GVs=" + GVs // NOI18N
              + ", TYs=" + TYs // NOI18N
              + ", Scopes=" + Scopes // NOI18N
              + ", NodesSeen=" + NodesSeen; // NOI18N
  }
}
