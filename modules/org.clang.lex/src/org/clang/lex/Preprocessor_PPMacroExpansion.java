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
package org.clang.lex;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clang.lex.llvm.*;
import org.clang.basic.*;
import static org.clank.support.Native.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.lex.impl.PPMacroExpansionStatics.*;
import org.clang.lex.java.impl.*;
import static org.clang.lex.Preprocessor.EXPANDED_TOKENS_CAPACITY_TO_KEEP_AS_VECTOR;
import static org.clang.lex.Preprocessor.EXPANDED_TOKENS_IN_ONE_STACK_MAX_CAPACITY;
import org.clank.java.*;
import static org.clank.java.std.*;
import org.clank.java.std.tm;
import org.clank.support.*;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.llvm.adt.NoneType.None;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type Preprocessor_PPMacroExpansion">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor@this -extends=Preprocessor_PPLexerChange ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor13dumpMacroInfoEPKNS_14IdentifierInfoE;_ZN5clang12Preprocessor14addModuleMacroEPNS_6ModuleEPNS_14IdentifierInfoEPNS_9MacroInfoEN4llvm8ArrayRefIPNS_11ModuleMacroEEERb;_ZN5clang12Preprocessor14getModuleMacroEPNS_6ModuleEPNS_14IdentifierInfoE;_ZN5clang12Preprocessor15markMacroAsUsedEPNS_9MacroInfoE;_ZN5clang12Preprocessor18ExpandBuiltinMacroERNS_5TokenE;_ZN5clang12Preprocessor19isNextPPTokenLParenEv;_ZN5clang12Preprocessor20appendMacroDirectiveEPNS_14IdentifierInfoEPNS_14MacroDirectiveE;_ZN5clang12Preprocessor21RegisterBuiltinMacrosEv;_ZN5clang12Preprocessor21updateModuleMacroInfoEPKNS_14IdentifierInfoERNS0_15ModuleMacroInfoE;_ZN5clang12Preprocessor23setLoadedMacroDirectiveEPNS_14IdentifierInfoEPNS_14MacroDirectiveE;_ZN5clang12Preprocessor24cacheMacroExpandedTokensEPNS_10TokenLexerEN4llvm8ArrayRefINS_5TokenEEE;_ZN5clang12Preprocessor25ReadFunctionLikeMacroArgsERNS_5TokenEPNS_9MacroInfoERNS_14SourceLocationE;_ZN5clang12Preprocessor29HandleMacroExpandedIdentifierERNS_5TokenERKNS_15MacroDefinitionE;_ZN5clang12Preprocessor42removeCachedMacroExpandedTokensOfLastLexerEv;_ZNK5clang12Preprocessor29getLocalMacroDirectiveHistoryEPKNS_14IdentifierInfoE; -static-type=Preprocessor_PPMacroExpansion -package=org.clang.lex")
//</editor-fold>
public class Preprocessor_PPMacroExpansion extends Preprocessor_PPLexerChange {
private final /*split clang::Preprocessor*/ Preprocessor $this() { return (Preprocessor)this; }


/// \brief Given an identifier, return the latest non-imported macro
/// directive for that identifier.
///
/// One can iterate over all previous macro directives from the most recent
/// one.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getLocalMacroDirectiveHistory">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 36,
   FQN="clang::Preprocessor::getLocalMacroDirectiveHistory", NM="_ZNK5clang12Preprocessor29getLocalMacroDirectiveHistoryEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZNK5clang12Preprocessor29getLocalMacroDirectiveHistoryEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public MacroDirective /*P*/ getLocalMacroDirectiveHistory(/*const*/ IdentifierInfo /*P*/ II) /*const*/ {
    if (!II.hadMacroDefinition()) {
      return null;
    }
  
    MacroState Out = $this().CurSubmoduleState.Macros.lookup(II);
    return Out == null ? null : Out.getLatest();
  }


/// \brief Add a directive to the macro directive history for this identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::appendMacroDirective">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 45,
   FQN="clang::Preprocessor::appendMacroDirective", NM="_ZN5clang12Preprocessor20appendMacroDirectiveEPNS_14IdentifierInfoEPNS_14MacroDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor20appendMacroDirectiveEPNS_14IdentifierInfoEPNS_14MacroDirectiveE")
  //</editor-fold>
  public void appendMacroDirective(IdentifierInfo /*P*/ II, MacroDirective /*P*/ MD) {
    assert ((MD != null)) : "MacroDirective should be non-zero!";
    assert (!(MD.getPrevious() != null)) : "Already attached to a MacroDirective history.";

    // MANUAL_SEMANTIC
    pair<IdentifierInfo, MacroState> SPair = $this().CurSubmoduleState.Macros.FindAndConstruct(II);
    if (SPair.second == null) {
      SPair.second = new MacroState();
    } else {
      assert (SPair.second != null);
    }
    MacroState /*&*/ StoredMD = SPair.second;    
    MacroDirective /*P*/ OldMD = StoredMD.getLatest();
    MD.setPrevious(OldMD);
    StoredMD.setLatest(MD);
    StoredMD.overrideActiveModuleMacros($Deref($this()), II);
    if ($this().needModuleMacros()) {
      // Track that we created a new macro directive, so we know we should
      // consider building a ModuleMacro for it when we get to the end of
      // the module.
      $this().PendingModuleMacroNames.push_back(II);
    }
    
    // Set up the identifier as having associated macro history.
    II.setHasMacroDefinition(true);
    if (!MD.isDefined() && ($this().LeafModuleMacros.count(II) == 0)) {
      II.setHasMacroDefinition(false);
    }
    if (II.isFromAST()) {
      II.setChangedSinceDeserialization();
    }
  }

/// \brief Set a MacroDirective that was loaded from a PCH file.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setLoadedMacroDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 70,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 63,
   FQN="clang::Preprocessor::setLoadedMacroDirective", NM="_ZN5clang12Preprocessor23setLoadedMacroDirectiveEPNS_14IdentifierInfoEPNS_14MacroDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor23setLoadedMacroDirectiveEPNS_14IdentifierInfoEPNS_14MacroDirectiveE")
  //</editor-fold>
  public void setLoadedMacroDirective(IdentifierInfo /*P*/ II, 
                         MacroDirective /*P*/ MD) {
      assert ((II != null) && (MD != null));      
      // MANUAL_SEMANTIC
//      final MacroState /*&*/ StoredMD = $this().CurSubmoduleState.Macros.$at(II);
      pair<IdentifierInfo, MacroState> SPair = $this().CurSubmoduleState.Macros.FindAndConstruct(II);
      if (SPair.second == null) {
        SPair.second = new MacroState();
      } else {
        assert (SPair.second != null);
      }
      MacroState /*&*/ StoredMD = SPair.second;
      assert StoredMD != null;
      assert (!(StoredMD.getLatest() != null)) : "the macro history was modified before initializing it from a pch";
      StoredMD.$assignMove(new MacroState(MD));
      // Setup the identifier as having associated macro history.
      II.setHasMacroDefinition(true);
      if (!MD.isDefined() && ($this().LeafModuleMacros.count(II) == 0)) {
        II.setHasMacroDefinition(false);
      }
  }


/// \brief Register an exported macro for a module and identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::addModuleMacro">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 83,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 76,
   FQN="clang::Preprocessor::addModuleMacro", NM="_ZN5clang12Preprocessor14addModuleMacroEPNS_6ModuleEPNS_14IdentifierInfoEPNS_9MacroInfoEN4llvm8ArrayRefIPNS_11ModuleMacroEEERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor14addModuleMacroEPNS_6ModuleEPNS_14IdentifierInfoEPNS_9MacroInfoEN4llvm8ArrayRefIPNS_11ModuleMacroEEERb")
  //</editor-fold>
  public ModuleMacro /*P*/ addModuleMacro(Module /*P*/ Mod, IdentifierInfo /*P*/ II, 
                MacroInfo /*P*/ Macro, 
                ArrayRef<ModuleMacro /*P*/ > Overrides, 
                bool$ref/*bool &*/ New) {
    FoldingSetNodeID ID = null;
    try {
      ID/*J*/= new FoldingSetNodeID();
      ModuleMacro.Profile(ID, Mod, II);
      
      type$ref<type$ptr<ModuleMacro /*P*/>>/*void P*/ InsertPos = NativePointer.create_type$ref(null);
      {
        ModuleMacro /*P*/ MM = $this().ModuleMacros.FindNodeOrInsertPos(ID, InsertPos);
        if ((MM != null)) {
          New.$set(false);
          return MM;
        }
      }
      
      ModuleMacro /*P*/ MM = ModuleMacro.create($Deref($this()), Mod, II, Macro, new ArrayRef<ModuleMacro /*P*/ >(Overrides));
      $this().ModuleMacros.InsertNode(MM, InsertPos.$deref());
      
      // Each overridden macro is now overridden by one more macro.
      boolean HidAny = false;
      for (ModuleMacro /*P*/ O : Overrides) {
        HidAny |= (O.NumOverriddenBy == 0);
        ++O.NumOverriddenBy;
      }
      
      // If we were the first overrider for any macro, it's no longer a leaf.
      TinyPtrVector<ModuleMacro /*P*/ > /*&*/ LeafMacros = $this().LeafModuleMacros.$at(II);
      if (HidAny) {
        LeafMacros.erase(std.remove_if(LeafMacros.begin(), LeafMacros.end(), 
                                        /*[]*/(ModuleMacro /*P*/ _MM) -> {
                                          return _MM.NumOverriddenBy != 0;
                                        }), 
                        LeafMacros.end());
      }
      
      // The new macro is always a leaf macro.
      LeafMacros.push_back(MM);
      // The identifier now has defined macros (that may or may not be visible).
      II.setHasMacroDefinition(true);
      
      New.$set(true);
      return MM;
    } finally {
      if (ID != null) { ID.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getModuleMacro">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 125,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 118,
   FQN="clang::Preprocessor::getModuleMacro", NM="_ZN5clang12Preprocessor14getModuleMacroEPNS_6ModuleEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor14getModuleMacroEPNS_6ModuleEPNS_14IdentifierInfoE")
  //</editor-fold>
  public ModuleMacro /*P*/ getModuleMacro(Module /*P*/ Mod, IdentifierInfo /*P*/ II) {
    FoldingSetNodeID ID = null;
    try {
      ID/*J*/= new FoldingSetNodeID();
      ModuleMacro.Profile(ID, Mod, II);
      
      type$ref<type$ptr<ModuleMacro/*P*/>>/*void P*/ InsertPos = NativePointer.create_type$ref(null);
      return $this().ModuleMacros.FindNodeOrInsertPos(ID, InsertPos);
    } finally {
      if (ID != null) { ID.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::dumpMacroInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 211,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 204,
   FQN="clang::Preprocessor::dumpMacroInfo", NM="_ZN5clang12Preprocessor13dumpMacroInfoEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor13dumpMacroInfoEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public void dumpMacroInfo(/*const*/ IdentifierInfo /*P*/ II) {
    $this().dumpMacroInfo(II, llvm.errs());
  }
  public void dumpMacroInfo(/*const*/ IdentifierInfo /*P*/ II, raw_ostream /*&*/ llvm$errs/*=llvm.errs()*/) {
    ArrayRef<ModuleMacro /*P*/ > Leaf/*J*/= new ArrayRef<ModuleMacro /*P*/ >();
    DenseMapIterator</*const*/ IdentifierInfo /*P*/ , TinyPtrVector<ModuleMacro /*P*/>> LeafIt = $this().LeafModuleMacros.find(II);
    if (LeafIt.$noteq(/*NO_ITER_COPY*/$this().LeafModuleMacros.end())) {
      Leaf.$assignMove(LeafIt.$arrow().second.$MutableArrayRef$EltTy());
    }
    /*const*/ MacroState /*P*/ State = null;
    DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> Pos = $this().CurSubmoduleState.Macros.find(II);
    if (Pos.$noteq(/*NO_ITER_COPY*/$this().CurSubmoduleState.Macros.end())) {
      State = $AddrOf(Pos.$arrow().second);
    }
    
    llvm$errs.$out(/*KEEP_STR*/"MacroState ").$out(State).$out(/*KEEP_STR*/$SPACE).$out(II.getNameStart());
    if ((State != null) && State.isAmbiguous($Deref($this()), II)) {
      llvm$errs.$out(/*KEEP_STR*/" ambiguous");
    }
    if ((State != null) && !State.getOverriddenMacros().empty()) {
      llvm$errs.$out(/*KEEP_STR*/" overrides");
      for (ModuleMacro /*P*/ O : State.getOverriddenMacros())  {
        llvm$errs.$out(/*KEEP_STR*/$SPACE).$out(O.getOwningModule().getFullModuleName());
      }
    }
    llvm$errs.$out(/*KEEP_STR*/$LF);
    
    // Dump local macro directives.
    for (MacroDirective /*P*/ MD = (State != null) ? State.getLatest() : null; (MD != null);
         MD = MD.getPrevious()) {
      llvm$errs.$out(/*KEEP_STR*/$SPACE);
      MD.dump(llvm$errs);
    }
    
    // Dump module macros.
    DenseSet<ModuleMacro /*P*/ > Active/*J*/= new DenseSet<ModuleMacro /*P*/ >(DenseMapInfo$LikePtr.$Info());
    for (ModuleMacro /*P*/ MM : (State != null) ? State.getActiveModuleMacros($Deref($this()), II) : new ArrayRef<ModuleMacro /*P*/ >(None))  {
      Active.insert(MM);
    }
    DenseSet<ModuleMacro /*P*/ > Visited/*J*/= new DenseSet<ModuleMacro /*P*/ >(DenseMapInfo$LikePtr.$Info());
    SmallVector<ModuleMacro /*P*/ > Worklist/*J*/= new SmallVector<ModuleMacro /*P*/ >(16, Leaf.begin(), Leaf.end(), (ModuleMacro /*P*/ )null);
    while (!Worklist.empty()) {
      ModuleMacro /*P*/ MM = Worklist.pop_back_val();
      llvm$errs.$out(/*KEEP_STR*/" ModuleMacro ").$out(MM).$out(/*KEEP_STR*/$SPACE).$out(MM.getOwningModule().getFullModuleName());
      if (!(MM.getMacroInfo() != null)) {
        llvm$errs.$out(/*KEEP_STR*/" undef");
      }
      if ((Active.count(MM) != 0)) {
        llvm$errs.$out(/*KEEP_STR*/" active");
      } else if (!$this().CurSubmoduleState.VisibleModules.isVisible(MM.getOwningModule())) {
        llvm$errs.$out(/*KEEP_STR*/" hidden");
      } else if ((MM.getMacroInfo() != null)) {
        llvm$errs.$out(/*KEEP_STR*/" overridden");
      }
      if (!MM.overrides().empty()) {
        llvm$errs.$out(/*KEEP_STR*/" overrides");
        for (ModuleMacro /*P*/ O : MM.overrides()) {
          llvm$errs.$out(/*KEEP_STR*/$SPACE).$out(O.getOwningModule().getFullModuleName());
          if (Visited.insert(O).second) {
            Worklist.push_back(O);
          }
        }
      }
      llvm$errs.$out(/*KEEP_STR*/$LF);
      {
        MacroInfo /*P*/ MI = MM.getMacroInfo();
        if ((MI != null)) {
          llvm$errs.$out(/*KEEP_STR*/"  ");
          MI.dump(llvm$errs);
          llvm$errs.$out(/*KEEP_STR*/$LF);
        }
      }
    }
  }


/// Update the set of active module macros and ambiguity flag for a module
/// macro name.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::updateModuleMacroInfo">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 133,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 126,
   FQN="clang::Preprocessor::updateModuleMacroInfo", NM="_ZN5clang12Preprocessor21updateModuleMacroInfoEPKNS_14IdentifierInfoERNS0_15ModuleMacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor21updateModuleMacroInfoEPKNS_14IdentifierInfoERNS0_15ModuleMacroInfoE")
  //</editor-fold>
  protected /*private*/ void updateModuleMacroInfo(/*const*/ IdentifierInfo /*P*/ II, 
                       ModuleMacroInfo /*&*/ Info) {
    assert (Info.ActiveModuleMacrosGeneration != $this().CurSubmoduleState.VisibleModules.getGeneration()) : "don't need to update this macro name info";
    Info.ActiveModuleMacrosGeneration
       = $this().CurSubmoduleState.VisibleModules.getGeneration();

    DenseMapIterator</*const*/ IdentifierInfo /*P*/, TinyPtrVector<ModuleMacro /*P*/ >> Leaf = $this().LeafModuleMacros.find(II);
    if (Leaf.$eq(/*NO_ITER_COPY*/$this().LeafModuleMacros.end())) {
      // No imported macros at all: nothing to do.
      return;
    }

    Info.ActiveModuleMacros.clear();

    // Every macro that's locally overridden is overridden by a visible macro.
    DenseMapTypeInt<ModuleMacro /*P*/ > NumHiddenOverrides/*J*/= new DenseMapTypeInt<ModuleMacro /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    for (ModuleMacro /*P*/ O : Info.OverriddenMacros)  {
      NumHiddenOverrides.$set(O, -1);
    }

    // Collect all macros that are not overridden by a visible macro.
    SmallVector<ModuleMacro /*P*/ > Worklist/*J*/= new SmallVector<ModuleMacro /*P*/ >(16, (ModuleMacro /*P*/ )null);
    for (ModuleMacro /*P*/ LeafMM : Leaf.$arrow().second) {
      assert (LeafMM.getNumOverridingMacros() == 0) : "leaf macro overridden";
      if (NumHiddenOverrides.lookup(LeafMM) == 0) {
        Worklist.push_back(LeafMM);
      }
    }
    while (!Worklist.empty()) {
      ModuleMacro /*P*/ MM = Worklist.pop_back_val();
      if ($this().CurSubmoduleState.VisibleModules.isVisible(MM.getOwningModule())) {
        // We only care about collecting definitions; undefinitions only act
        // to override other definitions.
        if ((MM.getMacroInfo() != null)) {
          Info.ActiveModuleMacros.push_back(MM);
        }
      } else {
        for (ModuleMacro /*P*/ O : MM.overrides())  {
          if (NumHiddenOverrides.ref$at(O).$set$preInc() == O.getNumOverridingMacros()) {
            Worklist.push_back(O);
          }
        }
      }
    }
    // Our reverse postorder walk found the macros in reverse order.
    std.reverse(Info.ActiveModuleMacros.begin(), Info.ActiveModuleMacros.end());

    // Determine whether the macro name is ambiguous.
    MacroInfo /*P*/ MI = null;
    boolean IsSystemMacro = true;
    boolean IsAmbiguous = false;
    {
      MacroDirective /*P*/ MD = Info.MD;
      if ((MD != null)) {
        while ((MD != null) && isa(VisibilityMacroDirective.class, MD)) {
          MD = MD.getPrevious();
        }
        {
          DefMacroDirective /*P*/ DMD = dyn_cast_or_null(DefMacroDirective.class, MD);
          if ((DMD != null)) {
            MI = DMD.getInfo();
            IsSystemMacro &= $this().SourceMgr.isInSystemHeader(DMD.getLocation());
          }
        }
      }
    }
    for (ModuleMacro /*P*/ Active : Info.ActiveModuleMacros) {
      MacroInfo /*P*/ NewMI = Active.getMacroInfo();

      // Before marking the macro as ambiguous, check if this is a case where
      // both macros are in system headers. If so, we trust that the system
      // did not get it wrong. This also handles cases where Clang's own
      // headers have a different spelling of certain system macros:
      //   #define LONG_MAX __LONG_MAX__ (clang's limits.h)
      //   #define LONG_MAX 0x7fffffffffffffffL (system's limits.h)
      //
      // FIXME: Remove the defined-in-system-headers check. clang's limits.h
      // overrides the system limits.h's macros, so there's no conflict here.
      if ((MI != null) && NewMI != MI
         && !MI.isIdenticalTo($Deref(NewMI), $Deref($this()), /*Syntactically=*/ true)) {
        IsAmbiguous = true;
      }
      IsSystemMacro &= Active.getOwningModule().IsSystem
         || $this().SourceMgr.isInSystemHeader(NewMI.getDefinitionLoc());
      MI = NewMI;
    }
    Info.IsAmbiguous = IsAmbiguous && !IsSystemMacro;
  }


/// \brief Register builtin macros such as __LINE__ with the identifier table.

/// RegisterBuiltinMacros - Register builtin macros, such as __LINE__ with the
/// identifier table.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::RegisterBuiltinMacros">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 292,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 285,
   FQN="clang::Preprocessor::RegisterBuiltinMacros", NM="_ZN5clang12Preprocessor21RegisterBuiltinMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor21RegisterBuiltinMacrosEv")
  //</editor-fold>
  protected /*private*/ void RegisterBuiltinMacros() {
    $this().Ident__LINE__ = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__LINE__");
    $this().Ident__FILE__ = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__FILE__");
    $this().Ident__DATE__ = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__DATE__");
    $this().Ident__TIME__ = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__TIME__");
    $this().Ident__COUNTER__ = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__COUNTER__");
    $this().Ident_Pragma = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"_Pragma");
    
    // C++ Standing Document Extensions.
    if ($this().LangOpts.CPlusPlus) {
      $this().Ident__has_cpp_attribute
         = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__has_cpp_attribute");
    } else {
      $this().Ident__has_cpp_attribute = null;
    }
    
    // GCC Extensions.
    $this().Ident__BASE_FILE__ = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__BASE_FILE__");
    $this().Ident__INCLUDE_LEVEL__ = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__INCLUDE_LEVEL__");
    $this().Ident__TIMESTAMP__ = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__TIMESTAMP__");
    
    // Microsoft Extensions.
    if ($this().LangOpts.MicrosoftExt) {
      $this().Ident__identifier = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__identifier");
      $this().Ident__pragma = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__pragma");
    } else {
      $this().Ident__identifier = null;
      $this().Ident__pragma = null;
    }
    
    // Clang Extensions.
    $this().Ident__has_feature = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__has_feature");
    $this().Ident__has_extension = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__has_extension");
    $this().Ident__has_builtin = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__has_builtin");
    $this().Ident__has_attribute = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__has_attribute");
    $this().Ident__has_declspec = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__has_declspec_attribute");
    $this().Ident__has_include = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__has_include");
    $this().Ident__has_include_next = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__has_include_next");
    $this().Ident__has_warning = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__has_warning");
    $this().Ident__is_identifier = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__is_identifier");
    
    // Modules.
    $this().Ident__building_module = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__building_module");
    if (!$this().LangOpts.CurrentModule.empty()) {
      $this().Ident__MODULE__ = RegisterBuiltinMacro($Deref($this()), /*KEEP_STR*/"__MODULE__");
    } else {
      $this().Ident__MODULE__ = null;
    }
  }


/// If an identifier token is read that is to be expanded as a macro, handle
/// it and return the next token as 'Tok'.  If we lexed a token, return true;
/// otherwise the caller should lex again.

/// HandleMacroExpandedIdentifier - If an identifier token is read that is to be
/// expanded as a macro, handle it and return the next token as 'Identifier'.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleMacroExpandedIdentifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 419,
   FQN="clang::Preprocessor::HandleMacroExpandedIdentifier", NM="_ZN5clang12Preprocessor29HandleMacroExpandedIdentifierERNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor29HandleMacroExpandedIdentifierERNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  protected /*private*/ boolean HandleMacroExpandedIdentifier(Token /*&*/ Identifier, 
                               /*const*/ MacroDefinition /*&*/ M) {
    MacroInfo /*P*/ MI = M.getMacroInfo();
    
    // If this is a macro expansion in the "#if !defined(x)" line for the file,
    // then the macro could expand to different things in other contexts, we need
    // to disable the optimization in this case.
    if (($this().CurPPLexer != null)) {
      $this().CurPPLexer.MIOpt.ExpandedMacro();
    }
    
    // If this is a builtin macro, like __LINE__ or _Pragma, handle it specially.
    if (MI.isBuiltinMacro()) {
      if ($this().Callbacks$boolean) {
        SourceRange SR = $this().$getExpansionSourceRange(Identifier.$getLocation(), Identifier.$getLocation());
        $this().Callbacks$arrow.MacroExpands(Identifier, M, SR, 
                /*Args=*/ (/*const*/ MacroArgs /*P*/ )null);
        $this().$releaseExpansionSourceRange(SR);
      }
      $this().ExpandBuiltinMacro(Identifier);
      return true;
    }
    
    /// Args - If this is a function-like macro expansion, this contains,
    /// for each macro argument, the list of tokens that were provided to the
    /// invocation.
    MacroArgs /*P*/ Args = null;
    
    // Remember where the end of the expansion occurred.  For an object-like
    // macro, this is the identifier.  For a function-like macro, this is the ')'.
    /*SourceLocation*/int ExpansionEnd = Identifier.$getLocation();
    
    // If this is a function-like macro, read the arguments.
    if (MI.isFunctionLike()) {
      // Remember that we are now parsing the arguments to a macro invocation.
      // Preprocessor directives used inside macro arguments are not portable, and
      // this enables the warning.
      $this().InMacroArgs = true;
      // Java avoid passing reference to get MacroEnd via dedicated variable. Store previous value in case of recursion
      final int InMacroArgs$ExpansionEnd$Previous = $this().InMacroArgs$ExpansionEnd;
      $this().InMacroArgs$ExpansionEnd = ExpansionEnd;
      Args = $this().ReadFunctionLikeMacroArgs(Identifier, MI);
      ExpansionEnd = $this().InMacroArgs$ExpansionEnd;
      $this().InMacroArgs$ExpansionEnd = InMacroArgs$ExpansionEnd$Previous;
      // Finished parsing args.
      $this().InMacroArgs = false;
      
      // If there was an error parsing the arguments, bail out.
      if (Args == null) {
        return true;
      }
      
      ++$this().NumFnMacroExpanded;
    } else {
      ++$this().NumMacroExpanded;
    }
    
    // Notice that this macro has been used.
    $this().markMacroAsUsed(MI);
    
    // Remember where the token is expanded.
    /*SourceLocation*/int ExpandLoc = Identifier.$getLocation();
    if ($this().Callbacks$boolean) {
      SourceRange ExpansionRange/*J*/= $this().$getExpansionSourceRange(ExpandLoc, ExpansionEnd);
      if ($this().InMacroArgs) {
        // We can have macro expansion inside a conditional directive while
        // reading the function macro arguments. To ensure, in that case, that
        // MacroExpands callbacks still happen in source order, queue this
        // callback to have it happen after the function macro callback.
        $this().DelayedMacroExpandsCallbacks.push_back(new MacroExpandsInfo(Identifier, M, ExpansionRange));
      } else {
        $this().Callbacks$arrow.MacroExpands(Identifier, M, /*NO_COPY*/ExpansionRange, Args);
        if (!$this().DelayedMacroExpandsCallbacks.empty()) {
          for (/*uint*/int i = 0, e = $this().DelayedMacroExpandsCallbacks.size(); i != e; ++i) {
            MacroExpandsInfo /*&*/ Info = $this().DelayedMacroExpandsCallbacks.$at(i);
            // FIXME: We lose macro args info with delayed callback.
            $this().Callbacks$arrow.MacroExpands(Info.Tok, Info.MD, /*NO_COPY*/Info.Range, 
                /*Args=*/ (/*const*/ MacroArgs /*P*/ )null);
          }
          $this().DelayedMacroExpandsCallbacks.clear();
        }
      }
      $this().$releaseExpansionSourceRange(ExpansionRange);
    }
    
    // If the macro definition is ambiguous, complain.
    if (M.isAmbiguous()) {
      $out_DiagnosticBuilder$C_IdentifierInfo$C$P($this().Diag(Identifier, diag.warn_pp_ambiguous_macro), 
              Identifier.getIdentifierInfo()).$destroy();
      $out_DiagnosticBuilder$C_IdentifierInfo$C$P($this().Diag(MI.$getDefinitionLoc(), diag.note_pp_ambiguous_macro_chosen), 
              Identifier.getIdentifierInfo()).$destroy();
      M.forAllDefinitions( (OtherMI) -> 
        {
          if (OtherMI != MI) {
            $out_DiagnosticBuilder$C_IdentifierInfo$C$P($this().Diag(OtherMI.getDefinitionLoc(), diag.note_pp_ambiguous_macro_other), 
                Identifier.getIdentifierInfo()).$destroy();
          }
        }
      );
    }
    
    // If we started lexing a macro, enter the macro expansion body.
    
    // If this macro expands to no tokens, don't bother to push it onto the
    // expansion stack, only to take it right back off.
    if (MI.getNumTokens() == 0) {
      // No need for arg info.
      if ((Args != null)) {
        Args.destroy($Deref($this()));
      }
      
      // Propagate whitespace info as if we had pushed, then popped,
      // a macro context.
      Identifier.setFlag(Token.TokenFlags.LeadingEmptyMacro);
      $this().PropagateLineStartLeadingSpaceInfo(Identifier);
      ++$this().NumFastMacroExpanded;
      return false;
    } else if (MI.getNumTokens() == 1 
        && isTrivialSingleTokenExpansion(MI, Identifier.getIdentifierInfo(), 
                $Deref($this()))) {
      // Otherwise, if this macro expands into a single trivially-expanded
      // token: expand it now.  This handles common cases like
      // "#define VAL 42".
      
      // No need for arg info.
      if ((Args != null)) {
        Args.destroy($Deref($this()));
      }
      
      // Propagate the isAtStartOfLine/hasLeadingSpace markers of the macro
      // identifier to the expanded token.
      boolean isAtStartOfLine = Identifier.isAtStartOfLine();
      boolean hasLeadingSpace = Identifier.hasLeadingSpace();
      
      // Replace the result token.
      Identifier.$assign(MI.getReplacementToken(0));
      
      // Restore the StartOfLine/LeadingSpace markers.
      Identifier.setFlagValue(Token.TokenFlags.StartOfLine, isAtStartOfLine);
      Identifier.setFlagValue(Token.TokenFlags.LeadingSpace, hasLeadingSpace);
      
      // Update the tokens location to include both its expansion and physical
      // locations.
      /*SourceLocation*/int Loc = $this().SourceMgr.createExpansionLoc(Identifier.$getLocation(), /*NO_COPY*/ExpandLoc, 
              /*NO_COPY*/ExpansionEnd, Identifier.getLength());
      Identifier.setLocation(/*NO_COPY*/Loc);
      {
        
        // If this is a disabled macro or #define X X, we must mark the result as
        // unexpandable.
        IdentifierInfo /*P*/ NewII = Identifier.getIdentifierInfo();
        if ((NewII != null)) {
          {
            MacroInfo /*P*/ NewMI = $this().getMacroInfo(NewII);
            if ((NewMI != null)) {
              if (!NewMI.isEnabled() || NewMI == MI) {
                Identifier.setFlag(Token.TokenFlags.DisableExpand);
                // Don't warn for "#define X X" like "#define bool bool" from
                // stdbool.h.
                if (NewMI != MI || MI.isFunctionLike()) {
                  $this().Diag(Identifier, diag.pp_disabled_macro_expansion).$destroy();
                }
              }
            }
          }
        }
      }
      
      // Since this is not an identifier token, it can't be macro expanded, so
      // we're done.
      ++$this().NumFastMacroExpanded;
      return true;
    }
    
    // Start expanding the macro.
    $this().EnterMacro(Identifier, ExpansionEnd, MI, Args);
    return false;
  }


/// \brief Cache macro expanded tokens for TokenLexers.
//
/// Works like a stack; a TokenLexer adds the macro expanded tokens that is
/// going to lex in the cache and when it finishes the tokens are removed
/// from the end of the cache.

/// \brief Keeps macro expanded tokens for TokenLexers.
//
/// Works like a stack; a TokenLexer adds the macro expanded tokens that is
/// going to lex in the cache and when it finishes the tokens are removed
/// from the end of the cache.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::cacheMacroExpandedTokens">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 976,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 972,
   FQN="clang::Preprocessor::cacheMacroExpandedTokens", NM="_ZN5clang12Preprocessor24cacheMacroExpandedTokensEPNS_10TokenLexerEN4llvm8ArrayRefINS_5TokenEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor24cacheMacroExpandedTokensEPNS_10TokenLexerEN4llvm8ArrayRefINS_5TokenEEE")
  //</editor-fold>
  /*friend*//*private*/ int /*P*/ cacheMacroExpandedTokens(TokenLexer /*P*/ tokLexer, 
          SmallVectorToken tokens) {
    assert (tokLexer != null);
    if (tokens.empty()) {
      return 0;
    }

    final Token[] Tokens;
    /*size_t*/int newIndex;
    SmallVectorToken tokensToKeep;    
    // JAVA PERF: keeping all tokens in growing MacroExpandedTokens array make it huge
    // switch to collecting input SmallVectorToken on threshold
    if ((tokens.size() < EXPANDED_TOKENS_CAPACITY_TO_KEEP_AS_VECTOR) && 
        ($this().MacroExpandedTokens.size() + tokens.size() < EXPANDED_TOKENS_IN_ONE_STACK_MAX_CAPACITY)) {
      newIndex = $this().MacroExpandedTokens.size();
      boolean cacheNeedsToGrow = $this().MacroExpandedTokens.prepareBeforeAppend(tokens.size());
      $this().MacroExpandedTokens.append(tokens.$array(), 0, tokens.size());
      Tokens = $this().MacroExpandedTokens.$array();
      assert !cacheNeedsToGrow : "capacity must be enough on creation " + $this().MacroExpandedTokens.capacity();
      if (cacheNeedsToGrow) {
        // Go through all the TokenLexers whose 'Tokens' pointer points in the
        // buffer and update the pointers to the (potential) new buffer array.
        for (/*uint*/int i = 0, e = $this().MacroExpandingLexersStack.size(); i != e; ++i) {
          TokenLexer /*P*/ prevLexer = $this().MacroExpandingLexersStack.first$at(i);
          /*size_t*/int tokIndex = $this().MacroExpandingLexersStack.second$at(i);
  //        llvm.tie(prevLexer, tokIndex).$assign(MacroExpandingLexersStack.$at(i));
          prevLexer.$tieTokens(Tokens, tokIndex);
        }
      }
      // we don't keep SmallVectorToken in this branch, all in MacroExpandedTokens collection
      tokensToKeep = null;
      // release tokens for possible reuse
      $this().$releaseExpandFunctionArgumentsVector(tokens);
    } else {
      if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
        // notify only on enter in this mode
        if ($this().MacroExpandingLexersStack.empty() || $this().MacroExpandingLexersStack.back$tokens() == null) {
          if (NativeTrace.STAT_OUT_FOLDER == null) {
            llvm.errs().$out("Switch  ON collect expanded SmallVectorToken with first size ").$out(NativeTrace.formatNumber(tokens.size(), 12));
            llvm.errs().$out(" vs. ").$out(NativeTrace.formatNumber($this().MacroExpandedTokens.size(), 12));
            llvm.errs().$out(" and expanding stack with depth ").$out_uint($this().MacroExpandingLexersStack.size()).$out($LF);
          }
        }
      }
      // will be released in removeCachedMacroExpandedTokensOfLastLexer
      tokensToKeep = tokens;
      Tokens = tokens.$array();
      newIndex = 0;
    }
    tokLexer.Tokens = Tokens;
    $this().MacroExpandingLexersStack.push_back(tokLexer, tokensToKeep, newIndex);
    return newIndex;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::removeCachedMacroExpandedTokensOfLastLexer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1002,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 998,
   FQN="clang::Preprocessor::removeCachedMacroExpandedTokensOfLastLexer", NM="_ZN5clang12Preprocessor42removeCachedMacroExpandedTokensOfLastLexerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor42removeCachedMacroExpandedTokensOfLastLexerEv")
  //</editor-fold>
  protected /*private*/ void removeCachedMacroExpandedTokensOfLastLexer() {
    assert (!$this().MacroExpandingLexersStack.empty());
    // check if keep all in MacroExpandedTokens or switched to keeping SmallVectorToken collections
    SmallVectorToken tokens = $this().MacroExpandingLexersStack.back$tokens();
    int numTokens = 0;
    if (tokens == null) {
      /*size_t*/int tokIndex = $this().MacroExpandingLexersStack.back$second();
      assert (tokIndex < $this().MacroExpandedTokens.size());
      // Pop the cached macro expanded tokens from the end.
      $this().MacroExpandedTokens.resize(tokIndex);
    } else {
      numTokens = tokens.size();
      $this().$releaseExpandFunctionArgumentsVector(tokens);      
    }
    $this().MacroExpandingLexersStack.pop_back();
    if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
      // notify only on exit from this mode
      if (tokens != null) {         
        if ($this().MacroExpandingLexersStack.empty() || $this().MacroExpandingLexersStack.back$tokens() == null) {
          if (NativeTrace.STAT_OUT_FOLDER == null) {
            llvm.errs().$out("Switch OFF collect expanded SmallVectorToken with first size ").$out(NativeTrace.formatNumber(numTokens, 12));
            llvm.errs().$out(" vs. ").$out(NativeTrace.formatNumber($this().MacroExpandedTokens.size(), 12));
            llvm.errs().$out(" and expanding stack with depth ").$out_uint($this().MacroExpandingLexersStack.size()).$out($LF);          
          }
        }
      }
    }
  }


/// Determine whether the next preprocessor token to be
/// lexed is a '('.  If so, consume the token and return true, if not, this
/// method should have no observable side-effect on the lexed tokens.

/// isNextPPTokenLParen - Determine whether the next preprocessor token to be
/// lexed is a '('.  If so, consume the token and return true, if not, this
/// method should have no observable side-effect on the lexed tokens.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isNextPPTokenLParen">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 377,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 182,
   FQN="clang::Preprocessor::isNextPPTokenLParen", NM="_ZN5clang12Preprocessor19isNextPPTokenLParenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor19isNextPPTokenLParenEv")
  //</editor-fold>
  protected /*private*/ boolean isNextPPTokenLParen() {
    // Do some quick tests for rejection cases.
    /*uint*/int Val;
    if ($this().CurLexer.$bool()) {
      Val = $this().CurLexer.$arrow().isNextPPTokenLParen();
    } else if ($this().CurPTHLexer.$bool()) {
      Val = $this().CurPTHLexer.$arrow().isNextPPTokenLParen();
    } else {
      Val = $this().CurTokenLexer.$arrow().isNextTokenLParen();
    }
    if (Val == 2) {
      // We have run off the end.  If it's a source file we don't
      // examine enclosing ones (C99 5.1.1.2p4).  Otherwise walk up the
      // macro stack.
      if (($this().CurPPLexer != null)) {
        return false;
      }
      for (/*uint*/int i = $this().IncludeMacroStack.size(); i != 0; --i) {
        IncludeStackInfo /*&*/ Entry = $this().IncludeMacroStack.$at(i - 1);
        if (Entry.TheLexer.$bool()) {
          Val = Entry.TheLexer.$arrow().isNextPPTokenLParen();
        } else if (Entry.ThePTHLexer.$bool()) {
          Val = Entry.ThePTHLexer.$arrow().isNextPPTokenLParen();
        } else {
          Val = Entry.TheTokenLexer.$arrow().isNextTokenLParen();
        }
        if (Val != 2) {
          break;
        }
        
        // Ran off the end of a source file?
        if ((Entry.ThePPLexer != null)) {
          return false;
        }
      }
    }
    
    // Okay, if we know that the token is a '(', lex it and return.  Otherwise we
    // have found something that isn't a '(' or we found the end of the
    // translation unit.  In either case, return false.
    return Val == 1;
  }


/// After reading "MACRO(", this method is invoked to read all of the formal
/// arguments specified for the macro invocation.  Returns null on error.

/// ReadFunctionLikeMacroArgs - After reading "MACRO" and knowing that the next
/// token is the '(' of the macro, this method is invoked to read all of the
/// actual arguments specified for the macro invocation.  This returns null on
/// error.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ReadFunctionLikeMacroArgs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 706,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 519,
   FQN="clang::Preprocessor::ReadFunctionLikeMacroArgs", NM="_ZN5clang12Preprocessor25ReadFunctionLikeMacroArgsERNS_5TokenEPNS_9MacroInfoERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor25ReadFunctionLikeMacroArgsERNS_5TokenEPNS_9MacroInfoERNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ MacroArgs /*P*/ ReadFunctionLikeMacroArgs(Token /*&*/ MacroName, 
          MacroInfo /*P*/ MI/*,*/ 
          /*out SourceLocation MacroEnd is now cached in InMacroArgsExpansionEnd*/) {
    ReadFunctionLikeMacroArgsHelper helper = $this().$getReadFunctionLikeMacroArgsHelper();
    MacroArgs out = $this().ReadFunctionLikeMacroArgs(MacroName, MI, helper);
    $this().$releaseReadFunctionLikeMacroArgs(helper);
    return out;
  }
  protected /*private*/ MacroArgs /*P*/ ReadFunctionLikeMacroArgs(Token /*&*/ MacroName, 
          MacroInfo /*P*/ MI, 
          /*, out SourceLocation MacroEnd is now cached in InMacroArgsExpansionEnd,*/ 
          ReadFunctionLikeMacroArgsHelper helper) {
    // The number of fixed arguments to parse.
    /*uint*/int NumFixedArgsLeft = MI.getNumArgs();
    boolean isVariadic = MI.isVariadic();

    // Outer loop, while there are more arguments, keep reading them.
    final Token Tok/*J*/= helper.$Token();

    // Read arguments as unexpanded tokens.  This avoids issues, e.g., where
    // an argument value in a macro could expand to ',' or '(' or ')'.
    $this().LexUnexpandedToken(Tok);
    assert (Tok.is(tok.TokenKind.l_paren)) : "Error computing l-paren-ness?";

    // ArgTokens - Build up a list of tokens that make up each argument.  Each
    // argument is separated by an EOF token.  Use a SmallVector so we can avoid
    // heap allocations in the common case.
    final SmallVectorToken ArgTokens/*J*/= helper.$ArgTokens(NumFixedArgsLeft);
    boolean ContainsCodeCompletionTok = false;
    boolean FoundElidedComma = false;

    /*SourceLocation*/int TooManyArgsLoc/*J*/= SourceLocation.getInvalid();

    /*uint*/int NumActuals = 0;
    while (Tok.isNot(tok.TokenKind.r_paren)) {
      if (ContainsCodeCompletionTok && Tok.isOneOf(tok.TokenKind.eof, tok.TokenKind.eod)) {
        break;
      }
      assert (Tok.isOneOf(tok.TokenKind.l_paren, tok.TokenKind.comma)) : "only expect argument separators here";

      /*uint*/int ArgTokenStart = ArgTokens.size();
      /*SourceLocation*/int ArgStartLoc = Tok.$getLocation();

      // C99 6.10.3p11: Keep track of the number of l_parens we have seen.  Note
      // that we already consumed the first one.
      /*uint*/int NumParens = 0;
      while (true) {
        // Read arguments as unexpanded tokens.  This avoids issues, e.g., where
        // an argument value in a macro could expand to ',' or '(' or ')'.
        $this().LexUnexpandedToken(Tok);
        if (Tok.isOneOf(tok.TokenKind.eof, tok.TokenKind.eod)) { // "#if f(<eof>" & "#if f(\n"
          if (!ContainsCodeCompletionTok) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(MacroName, diag.err_unterm_macro_invoc)));
              $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(MI.getDefinitionLoc(), diag.note_macro_here)), 
                  MacroName.getIdentifierInfo()));
              // Do not lose the EOF/EOD.  Return it to the client.
              MacroName.$assign(Tok);
              return null;
            } finally {
              $c$.$destroy();
            }
          }
          // Do not lose the EOF/EOD.
          Token[] /*P*/ Toks = helper.$Toks();
          Toks[0].$assign(Tok);
          $this().EnterTokenStream(Toks, 0, 1, /*DisableMacroExpansion=*/ true, /*OwnsTokens=*/ true);
          break;
        } else if (Tok.is(tok.TokenKind.r_paren)) {
          // If we found the ) token, the macro arg list is done.
          if (NumParens-- == 0) {
            $this().InMacroArgs$ExpansionEnd = Tok.$getLocation();
            if (!ArgTokens.empty()
                    && ArgTokens.back().commaAfterElided()) {
              FoundElidedComma = true;
            }
            break;
          }
        } else if (Tok.is(tok.TokenKind.l_paren)) {
          ++NumParens;
        } else if (Tok.is(tok.TokenKind.comma) && NumParens == 0 
                && !((Tok.getFlags() & Token.TokenFlags.IgnoredComma) != 0)) {
          // In Microsoft-compatibility mode, single commas from nested macro
          // expansions should not be considered as argument separators. We test
          // for this with the IgnoredComma token flag above.

          // Comma ends this argument if there are more fixed arguments expected.
          // However, if this is a variadic macro, and this is part of the
          // variadic part, then the comma is just an argument token.
          if (!isVariadic) {
            break;
          }
          if (NumFixedArgsLeft > 1) {
            break;
          }
        } else if (Tok.is(tok.TokenKind.comment) && !$this().KeepMacroComments) {
          // If this is a comment token in the argument list and we're just in
          // -C mode (not -CC mode), discard the comment.
          continue;
        } else if (!Tok.isAnnotation() && Tok.getIdentifierInfo() != null) {
          {
            // Reading macro arguments can cause macros that we are currently
            // expanding from to be popped off the expansion stack.  Doing so causes
            // them to be reenabled for expansion.  Here we record whether any
            // identifiers we lex as macro arguments correspond to disabled macros.
            // If so, we mark the token as noexpand.  This is a subtle aspect of
            // C99 6.10.3.4p2.
            MacroInfo /*P*/ _MI = $this().getMacroInfo(Tok.getIdentifierInfo());
            if ((_MI != null)) {
              if (!_MI.isEnabled()) {
                Tok.setFlag(Token.TokenFlags.DisableExpand);
              }
            }
          }
        } else if (Tok.is(tok.TokenKind.code_completion)) {
          ContainsCodeCompletionTok = true;
          if (($this().CodeComplete != null)) {
            $this().CodeComplete.CodeCompleteMacroArgument(MacroName.getIdentifierInfo(), 
                    MI, NumActuals);
          }
          // Don't mark that we reached the code-completion point because the
          // parser is going to handle the token and there will be another
          // code-completion callback.
        }

        ArgTokens.push_back(Tok);
      }

      // If this was an empty argument list foo(), don't add this as an empty
      // argument.
      if (ArgTokens.empty() && Tok.getKind() == tok.TokenKind.r_paren) {
        break;
      }

      // If this is not a variadic macro, and too many args were specified, emit
      // an error.
      if (!isVariadic && NumFixedArgsLeft == 0 && SourceLocation.isInvalid(TooManyArgsLoc)) {
        if (ArgTokens.size() != ArgTokenStart) {
          TooManyArgsLoc = ArgTokens.$at(ArgTokenStart).$getLocation();
        } else {
          TooManyArgsLoc = ArgStartLoc;
        }
      }

      // Empty arguments are standard in C99 and C++0x, and are supported as an
      // extension in other modes.
      if (ArgTokens.size() == ArgTokenStart && !$this().LangOpts.C99) {
        $this().Diag(Tok, $this().LangOpts.CPlusPlus11 ? diag.warn_cxx98_compat_empty_fnmacro_arg : diag.ext_empty_fnmacro_arg).$destroy();
      }

      // Add a marker EOF token to the end of the token list for this argument.
      Token EOFTok/*J*/= helper.$EOFTok();
      EOFTok.startToken();
      EOFTok.setKind(tok.TokenKind.eof);
      EOFTok.setLocation(Tok.$getLocation());
      EOFTok.setLength(0);
      ArgTokens.push_back(EOFTok);
      ++NumActuals;
      if (!ContainsCodeCompletionTok && NumFixedArgsLeft != 0) {
        --NumFixedArgsLeft;
      }
    }

    // Okay, we either found the r_paren.  Check to see if we parsed too few
    // arguments.
    /*uint*/int MinArgsExpected = MI.getNumArgs();

    // If this is not a variadic macro, and too many args were specified, emit
    // an error.
    if (!isVariadic && NumActuals > MinArgsExpected 
            && !ContainsCodeCompletionTok) {
//        try {//PERF: remove try/finally
      // Emit the diagnostic at the macro name in case there is a missing ).
      // Emitting it at the , could be far away from the macro name.
      $this().Diag(TooManyArgsLoc, diag.err_too_many_args_in_macro_invoc).$destroy();
      $out_DiagnosticBuilder$C_IdentifierInfo$C$P($this().Diag(MI.$getDefinitionLoc(), diag.note_macro_here), MacroName.getIdentifierInfo()).$destroy();

      // Commas from braced initializer lists will be treated as argument
      // separators inside macros.  Attempt to correct for this with parentheses.
      // TODO: See if this can be generalized to angle brackets for templates
      // inside macro arguments.
      final SmallVectorToken FixedArgTokens/*J*/= new SmallVectorToken(4, /*PERF*/null /*new Token()*/);
      /*uint*/uint$ref FixedNumArgs = create_uint$ref(0);
      final SmallVector<SourceRange> ParenHints/*J*/= new SmallVector<SourceRange>(4, new SourceRange());
      final SmallVector<SourceRange> InitLists/*J*/= new SmallVector<SourceRange>(4, new SourceRange());
      if (!GenerateNewArgTokens($Deref($this()), ArgTokens, FixedArgTokens, FixedNumArgs, ParenHints, InitLists)) {
        if (!InitLists.empty()) {
          DiagnosticBuilder DB = null;
          try {
            DB = $this().Diag(MacroName, 
                diag.note_init_list_at_beginning_of_macro_argument);
            for (/*const*/ SourceRange /*&*/ Range : InitLists)  {
              $out_DiagnosticBuilder$C_SourceRange(DB, Range);
            }
          } finally {
            if (DB != null) { DB.$destroy(); }
          }
        }
        return null;
      }
      if (FixedNumArgs.$deref() != MinArgsExpected) {
        return null;
      }

      /*JAVA: PERF removed try/finally; added manual destroy*/
      DiagnosticBuilder DB = $this().Diag(MacroName, diag.note_suggest_parens_for_macro);
      for (/*const*/ SourceRange /*&*/ ParenLocation : ParenHints) {
        $out_DiagnosticBuilder$C_FixItHint$C(DB, FixItHint.CreateInsertion(ParenLocation.getBegin(), new StringRef($("("))));
        $out_DiagnosticBuilder$C_FixItHint$C(DB, FixItHint.CreateInsertion(ParenLocation.getEnd(), new StringRef($(")"))));
      }
      ArgTokens.swap(FixedArgTokens);
      NumActuals = FixedNumArgs.$deref();
      DB.$destroy();
    }

    // See MacroArgs instance var for description of this.
    boolean isVarargsElided = false;
    if (ContainsCodeCompletionTok) {
      // Recover from not-fully-formed macro invocation during code-completion.
      Token EOFTok/*J*/= helper.$EOFTok();
      EOFTok.startToken();
      EOFTok.setKind(tok.TokenKind.eof);
      EOFTok.setLocation(Tok.$getLocation());
      EOFTok.setLength(0);
      for (; NumActuals < MinArgsExpected; ++NumActuals)  {
        ArgTokens.push_back(EOFTok);
      }
    }
    if (NumActuals < MinArgsExpected) {
      // There are several cases where too few arguments is ok, handle them now.
      if (NumActuals == 0 && MinArgsExpected == 1) {
        // #define A(X)  or  #define A(...)   ---> A()

        // If there is exactly one argument, and that argument is missing,
        // then we have an empty "()" argument empty list.  This is fine, even if
        // the macro expects one argument (the argument is just empty).
        isVarargsElided = MI.isVariadic();
      } else if ((FoundElidedComma || MI.isVariadic())
         && (NumActuals + 1 == MinArgsExpected // A(x, ...) -> A(X)
         || (NumActuals == 0 && MinArgsExpected == 2))) { // A(x,...) -> A()
// Varargs where the named vararg parameter is missing: OK as extension.
//   #define A(x, ...)
//   A("blah")
//
// If the macro contains the comma pasting extension, the diagnostic
// is suppressed; we know we'll get another diagnostic later.
        if (!MI.hasCommaPasting()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(Tok, diag.ext_missing_varargs_arg)));
            $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(MI.getDefinitionLoc(), diag.note_macro_here)), 
                MacroName.getIdentifierInfo()));
          } finally {
            $c$.$destroy();
          }
        }

        // Remember this occurred, allowing us to elide the comma when used for
        // cases like:
        //   #define A(x, foo...) blah(a, ## foo)
        //   #define B(x, ...) blah(a, ## __VA_ARGS__)
        //   #define C(...) blah(a, ## __VA_ARGS__)
        //  A(x) B(x) C()
        isVarargsElided = true;
      } else if (!ContainsCodeCompletionTok) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Otherwise, emit the error.
          $c$.clean($c$.track($this().Diag(Tok, diag.err_too_few_args_in_macro_invoc)));
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(MI.getDefinitionLoc(), diag.note_macro_here)), 
              MacroName.getIdentifierInfo()));
          return null;
        } finally {
          $c$.$destroy();
        }
      }

      // Add a marker EOF token to the end of the token list for this argument.
      /*SourceLocation*/int EndLoc = Tok.$getLocation();
      Tok.startToken();
      Tok.setKind(tok.TokenKind.eof);
      Tok.setLocation(/*NO_COPY*/EndLoc);
      Tok.setLength(0);
      ArgTokens.push_back(Tok);

      // If we expect two arguments, add both as empty.
      if (NumActuals == 0 && MinArgsExpected == 2) {
        ArgTokens.push_back(Tok);
      }
    } else if ($greater_uint(NumActuals, MinArgsExpected) && !MI.isVariadic()
       && !ContainsCodeCompletionTok) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Emit the diagnostic at the macro name in case there is a missing ).
        // Emitting it at the , could be far away from the macro name.
        $c$.clean($c$.track($this().Diag(MacroName, diag.err_too_many_args_in_macro_invoc)));
        $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(MI.getDefinitionLoc(), diag.note_macro_here)), 
            MacroName.getIdentifierInfo()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }

    return MacroArgs.create(MI, ArgTokens, isVarargsElided, $Deref($this()));
  }


/// \brief If an identifier token is read that is to be expanded
/// as a builtin macro, handle it and return the next token as 'Tok'.

/// ExpandBuiltinMacro - If an identifier token is read that is to be expanded
/// as a builtin macro, handle it and return the next token as 'Tok'.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ExpandBuiltinMacro">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1540,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 1456,
   FQN="clang::Preprocessor::ExpandBuiltinMacro", NM="_ZN5clang12Preprocessor18ExpandBuiltinMacroERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor18ExpandBuiltinMacroERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void ExpandBuiltinMacro(Token /*&*/ Tok) {
    SmallString/*128*/ TmpBuffer = null; // JAVA PERF
    raw_svector_ostream OS = null; // JAVA PERF
    try {
      // Figure out which token this is.
      IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
      assert ((II != null)) : "Can't be a macro without id info!";
      
      // If this is an _Pragma or Microsoft __pragma directive, expand it,
      // invoke the pragma handler, then lex the token after it.
      if (II == $this().Ident_Pragma) {
        $this().Handle_Pragma(Tok);
        return;
      } else if (II == $this().Ident__pragma) { // in non-MS mode this is null
        $this().HandleMicrosoft__pragma(Tok);
        return;
      }
      
      ++$this().NumBuiltinMacroExpanded;
      
      TmpBuffer/*J*/= $this().$getExpandBuiltinMacro_TmpBuffer();
      //OS/*J*/= new raw_svector_ostream(TmpBuffer);
      OS/*J*/= $this().$getExpandBuiltinMacro_OS(TmpBuffer);
      
      // Set up the return result.
      Tok.setIdentifierInfo((IdentifierInfo /*P*/ )null);
      Tok.clearFlag(Token.TokenFlags.NeedsCleaning);
      if (II == $this().Ident__LINE__) {
        // C99 6.10.8: "__LINE__: The presumed line number (within the current
        // source file) of the current source line (an integer constant)".  This can
        // be affected by #line.
        /*SourceLocation*/int Loc = Tok.$getLocation();
        
        // Advance to the location of the first _, this might not be the first byte
        // of the token if it starts with an escaped newline.
        Loc = ($this().AdvanceToTokenCharacter(/*NO_COPY*/Loc, 0));
        
        // One wrinkle here is that GCC expands __LINE__ to location of the *end* of
        // a macro expansion.  This doesn't matter for object-like macros, but
        // can matter for a function-like macro that expands to contain __LINE__.
        // Skip down through expansion points until we find a file loc for the
        // end of the expansion history.
        Loc = $second_SourceLocation($this().SourceMgr.getExpansionRange(/*NO_COPY*/Loc));
        PresumedLoc PLoc = $this().SourceMgr.getPresumedLoc(/*NO_COPY*/Loc);
        
        // __LINE__ expands to a simple numeric value.
        OS.$out_uint((PLoc.isValid() ? PLoc.getLine() : 1));
        Tok.setKind(tok.TokenKind.numeric_constant);
      } else if (II == $this().Ident__FILE__ || II == $this().Ident__BASE_FILE__) {
        SmallString/*128*/ FN = null; // JAVA PERF
        try {        
          // C99 6.10.8: "__FILE__: The presumed name of the current source file (a
          // character string literal)". This can be affected by #line.
          PresumedLoc PLoc = $this().SourceMgr.getPresumedLoc(Tok.$getLocation());

          // __BASE_FILE__ is a GNU extension that returns the top of the presumed
          // #include stack instead of the current file.
          if (II == $this().Ident__BASE_FILE__ && PLoc.isValid()) {
            /*SourceLocation*/int NextLoc = PLoc.$getIncludeLoc();
            while (SourceLocation.isValid(NextLoc)) {
              PLoc.$assignMove($this().SourceMgr.getPresumedLoc(/*NO_COPY*/NextLoc));
              if (PLoc.isInvalid()) {
                break;
              }

              NextLoc = PLoc.$getIncludeLoc();
            }
          }

          // Escape this filename.  Turn '\' -> '\\' '"' -> '\"'
          FN/*J*/= $this().$getExpandBuiltinMacro_FN(); // JAVA PERF
//          SmallString/*128*/ FN/*J*/= new SmallString/*128*/(128); 
          if (PLoc.isValid()) {
            FN.$addassign(/*STRINGREF_STR*/PLoc.getFilename());
            Lexer.Stringify(FN);
            OS.$out_char($$DBL_QUOTE).$out(FN).$out_char($$DBL_QUOTE);
          }
          Tok.setKind(tok.TokenKind.string_literal);
        } finally {
          if (FN != null) { $this().$releaseExpandBuiltinMacro_FN(FN); }
        }
      } else if (II == $this().Ident__DATE__) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Tok.getLocation(), diag.warn_pp_date_time)));
          if (!$this().DATELoc.isValid()) {
            ComputeDATE_TIME($this().DATELoc, $this().TIMELoc, $Deref($this()));
          }
          Tok.setKind(tok.TokenKind.string_literal);
          Tok.setLength(strlen(/*KEEP_STR*/"\"Mmm dd yyyy\""));
          Tok.setLocation($this().SourceMgr.createExpansionLoc(/*NO_COPY*/$this().DATELoc.getRawEncoding(), Tok.$getLocation(), 
                  Tok.$getLocation(), 
                  Tok.getLength()));
          return;
        } finally {
          $c$.$destroy();
        }
      } else if (II == $this().Ident__TIME__) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Tok.getLocation(), diag.warn_pp_date_time)));
          if (!$this().TIMELoc.isValid()) {
            ComputeDATE_TIME($this().DATELoc, $this().TIMELoc, $Deref($this()));
          }
          Tok.setKind(tok.TokenKind.string_literal);
          Tok.setLength(strlen(/*KEEP_STR*/"\"hh:mm:ss\""));
          Tok.setLocation($this().SourceMgr.createExpansionLoc(/*NO_COPY*/$this().TIMELoc.getRawEncoding(), Tok.$getLocation(), 
                  Tok.$getLocation(), 
                  Tok.getLength()));
          return;
        } finally {
          $c$.$destroy();
        }
      } else if (II == $this().Ident__INCLUDE_LEVEL__) {
        // Compute the presumed include depth of this token.  This can be affected
        // by GNU line markers.
        /*uint*/int Depth = 0;
        
        PresumedLoc PLoc = $this().SourceMgr.getPresumedLoc(Tok.$getLocation());
        if (PLoc.isValid()) {
          PLoc.$assignMove($this().SourceMgr.getPresumedLoc(PLoc.$getIncludeLoc()));
          for (; PLoc.isValid(); ++Depth)  {
            PLoc.$assignMove($this().SourceMgr.getPresumedLoc(PLoc.$getIncludeLoc()));
          }
        }
        
        // __INCLUDE_LEVEL__ expands to a simple numeric value.
        OS.$out_uint(Depth);
        Tok.setKind(tok.TokenKind.numeric_constant);
      } else if (II == $this().Ident__TIMESTAMP__) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Tok.getLocation(), diag.warn_pp_date_time)));
          // MSVC, ICC, GCC, VisualAge C++ extension.  The generated string should be
          // of the form "Ddd Mmm dd hh::mm::ss yyyy", which is returned by asctime.
          
          // Get the file that we are lexing out of.  If we're currently lexing from
          // a macro, dig into the include stack.
          /*const*/ FileEntry /*P*/ CurFile = null;
          PreprocessorLexer /*P*/ TheLexer = $this().getCurrentFileLexer();
          if ((TheLexer != null)) {
            CurFile = $this().SourceMgr.getFileEntryForID(TheLexer.getFileID());
          }
          
          /*const*/char$ptr/*char P*/ Result;
          if ((CurFile != null)) {
            long/*time_t*/ TT = CurFile.getModificationTime();
             tm /*P*/ TM = localtime($AddrOf(TT));
            Result = $noClone(asctime(TM));
          } else {
            Result = $noClone($("??? ??? ?? ??:??:?? ????\n"));
          }
          // Surround the string with " and strip the trailing newline.
          OS.$out_char($$DBL_QUOTE).$out(new StringRef(Result).drop_back()).$out_char($$DBL_QUOTE);
          Tok.setKind(tok.TokenKind.string_literal);
        } finally {
          $c$.$destroy();
        }
      } else if (II == $this().Ident__COUNTER__) {
        // __COUNTER__ expands to a simple numeric value.
        OS.$out_uint($this().CounterValue++);
        Tok.setKind(tok.TokenKind.numeric_constant);
      } else if (II == $this().Ident__has_feature) {
        EvaluateFeatureLikeBuiltinMacro(OS, Tok, II, $Deref($this()), 
            (_Tok, HasLexedNextToken) -> 
                  {
                    IdentifierInfo /*P*/ _II = ExpectFeatureIdentifierInfo(_Tok, $Deref($this()), 
                        diag.err_feature_check_malformed);
                    return (((_II != null) && HasFeature($Deref($this()), _II.getName())) ? 1 : 0);
                  }
            );
      } else if (II == $this().Ident__has_extension) {
        EvaluateFeatureLikeBuiltinMacro(OS, Tok, II, $Deref($this()), 
            (_Tok, HasLexedNextToken) -> 
                  {
                    IdentifierInfo /*P*/ _II = ExpectFeatureIdentifierInfo(_Tok, $Deref($this()), 
                        diag.err_feature_check_malformed);
                    return (((_II != null) && HasExtension($Deref($this()), _II.getName())) ? 1 : 0);
                  }
            );
      } else if (II == $this().Ident__has_builtin) {
        EvaluateFeatureLikeBuiltinMacro(OS, Tok, II, $Deref($this()), 
            (_Tok, HasLexedNextToken) -> 
                  {
                    IdentifierInfo /*P*/ _II = ExpectFeatureIdentifierInfo(_Tok, $Deref($this()), 
                        diag.err_feature_check_malformed);
                    if (!(_II != null)) {
                      return /*false*/0;
                    } else if (_II.getBuiltinID() != 0) {
                      return /*true*/1;
                    } else {
                      /*const*/ LangOptions /*&*/ LangOpts = $this().getLangOpts();
                      return (new StringSwitchBool(_II.getName()).
                          Case(/*KEEP_STR*/"__make_integer_seq", LangOpts.CPlusPlus).
                          Case(/*KEEP_STR*/"__type_pack_element", LangOpts.CPlusPlus).
                          Default(false) ? 1 : 0);
                    }
                  }
            );
      } else if (II == $this().Ident__is_identifier) {
        EvaluateFeatureLikeBuiltinMacro(OS, Tok, II, $Deref($this()), 
            (_Tok, HasLexedNextToken) -> 
                  {
                    return (_Tok.is(tok.TokenKind.identifier) ? 1 : 0);
                  }
            );
      } else if (II == $this().Ident__has_attribute) {
        EvaluateFeatureLikeBuiltinMacro(OS, Tok, II, $Deref($this()), 
            (_Tok, HasLexedNextToken) -> 
                  {
                    IdentifierInfo /*P*/ _II = ExpectFeatureIdentifierInfo(_Tok, $Deref($this()), 
                        diag.err_feature_check_malformed);
                    return (_II != null) ? hasAttribute(AttrSyntax.GNU, (/*const*/ IdentifierInfo /*P*/ )null, _II, 
                        $this().getTargetInfo(), $this().getLangOpts()) : 0;
                  }
            );
      } else if (II == $this().Ident__has_declspec) {
        EvaluateFeatureLikeBuiltinMacro(OS, Tok, II, $Deref($this()), 
            (_Tok, HasLexedNextToken) -> 
                  {
                    IdentifierInfo /*P*/ _II = ExpectFeatureIdentifierInfo(_Tok, $Deref($this()), 
                        diag.err_feature_check_malformed);
                    return (_II != null) ? hasAttribute(AttrSyntax.Declspec, (/*const*/ IdentifierInfo /*P*/ )null, _II, 
                        $this().getTargetInfo(), $this().getLangOpts()) : 0;
                  }
            );
      } else if (II == $this().Ident__has_cpp_attribute) {
        EvaluateFeatureLikeBuiltinMacro(OS, Tok, II, $Deref($this()), 
            (_Tok, HasLexedNextToken) -> 
                  {
                    IdentifierInfo /*P*/ ScopeII = (IdentifierInfo /*P*/ )null;
                    IdentifierInfo /*P*/ _II = ExpectFeatureIdentifierInfo(_Tok, $Deref($this()), 
                        diag.err_feature_check_malformed);
                    if (!(_II != null)) {
                      return /*false*/0;
                    }
                    
                    // It is possible to receive a scope token.  Read the "::", if it is
                    // available, and the subsequent identifier.
                    $this().LexUnexpandedToken(_Tok);
                    if (_Tok.isNot(tok.TokenKind.coloncolon)) {
                      HasLexedNextToken.$set(true);
                    } else {
                      ScopeII = _II;
                      $this().LexUnexpandedToken(_Tok);
                      _II = ExpectFeatureIdentifierInfo(_Tok, $Deref($this()), 
                          diag.err_feature_check_malformed);
                    }
                    
                    return (_II != null) ? hasAttribute(AttrSyntax.CXX, ScopeII, _II, 
                        $this().getTargetInfo(), $this().getLangOpts()) : 0;
                  }
            );
      } else if (II == $this().Ident__has_include
         || II == $this().Ident__has_include_next) {
        // The argument to these two builtins should be a parenthesized
        // file name string literal using angle brackets (<>) or
        // double-quotes ("").
        boolean Value;
        if (II == $this().Ident__has_include) {
          Value = EvaluateHasInclude(Tok, II, $Deref($this()));
        } else {
          Value = EvaluateHasIncludeNext(Tok, II, $Deref($this()));
        }
        if (Tok.isNot(tok.TokenKind.r_paren)) {
          return;
        }
        OS.$out_int((int)(Value ? 1 : 0));
        Tok.setKind(tok.TokenKind.numeric_constant);
      } else if (II == $this().Ident__has_warning) {
        // The argument should be a parenthesized string literal.
        EvaluateFeatureLikeBuiltinMacro(OS, Tok, II, $Deref($this()), 
            (_Tok, HasLexedNextToken) -> 
                  {
                    std.string WarningName/*J*/= new std.string();
                    /*SourceLocation*/int StrStartLoc = _Tok.$getLocation();
                    
                    HasLexedNextToken.$set(_Tok.is(tok.TokenKind.string_literal));
                    if (!$this().FinishLexStringLiteral(_Tok, WarningName, /*KEEP_STR*/"'__has_warning'", 
                        /*MacroExpansion=*/ false)) {
                      return /*false*/0;
                    }
                    
                    // FIXME: Should we accept "-R..." flags here, or should that be
                    // handled by a separate __has_remark?
                    if ($less_uint(WarningName.size(), 3) || WarningName.$at(0) != $$MINUS
                       || WarningName.$at(1) != $$W) {
                      JavaCleaner $c$ = $createJavaCleaner();
                      try {
                        $c$.clean($c$.track($this().Diag(/*NO_COPY*/StrStartLoc, diag.warn_has_warning_invalid_option)));
                        return /*false*/0;
                      } finally {
                        $c$.$destroy();
                      }
                    }
                    
                    // Finally, check if the warning flags maps to a diagnostic group.
                    // We construct a SmallVector here to talk to getDiagnosticIDs().
                    // Although we don't use the result, this isn't a hot path, and not
                    // worth special casing.
                    SmallVectorUInt/*diag.kind*/ Diags/*J*/= new SmallVectorUInt/*diag.kind*/(10, 0);
                    return ((!$this().getDiagnostics().getDiagnosticIDs().$arrow().
                        getDiagnosticsInGroup(diag.Flavor.WarningOrError, 
                        new StringRef(WarningName.substr(2)), Diags)) ? 1 : 0);
                  }
            );
      } else if (II == $this().Ident__building_module) {
        // The argument to this builtin should be an identifier. The
        // builtin evaluates to 1 when that identifier names the module we are
        // currently building.
        EvaluateFeatureLikeBuiltinMacro(OS, Tok, II, $Deref($this()), 
            (_Tok, HasLexedNextToken) -> 
                  {
                    IdentifierInfo /*P*/ _II = ExpectFeatureIdentifierInfo(_Tok, $Deref($this()), 
                        diag.err_expected_id_building_module);
                    return (($this().getLangOpts().CompilingModule && (_II != null)
                       && ($eq_StringRef(_II.getName(), new StringRef($this().getLangOpts().CurrentModule)))) ? 1 : 0);
                  }
            );
      } else if (II == $this().Ident__MODULE__) {
        // JAVA PERF: extract CurrentModule once
        string CurrentModule = $this().getLangOpts().CurrentModule;
        // The current module as an identifier.
        OS.$out(CurrentModule);
        IdentifierInfo /*P*/ ModuleII = $this().getIdentifierInfo(CurrentModule);
        Tok.setIdentifierInfo(ModuleII);
        Tok.setKind(ModuleII.getTokenID());
      } else if (II == $this().Ident__identifier) {
        /*SourceLocation*/int Loc = Tok.$getLocation();
        
        // We're expecting '__identifier' '(' identifier ')'. Try to recover
        // if the parens are missing.
        $this().LexNonComment(Tok);
        if (Tok.isNot(tok.TokenKind.l_paren)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // No '(', use end of last token.
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag($this().getLocForEndOfToken(/*NO_COPY*/Loc), diag.err_pp_expected_after)), 
                    II), tok.TokenKind.l_paren));
            // If the next token isn't valid as our argument, we can't recover.
            if (!Tok.isAnnotation() && (Tok.getIdentifierInfo() != null)) {
              Tok.setKind(tok.TokenKind.identifier);
            }
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        /*SourceLocation*/int LParenLoc = Tok.$getLocation();
        $this().LexNonComment(Tok);
        if (!Tok.isAnnotation() && (Tok.getIdentifierInfo() != null)) {
          Tok.setKind(tok.TokenKind.identifier);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(Tok.getLocation(), diag.err_pp_identifier_arg_not_identifier)), 
                Tok.getKind()));
            // Don't walk past anything that's not a real token.
            if (Tok.isOneOf(tok.TokenKind.eof, tok.TokenKind.eod) || Tok.isAnnotation()) {
              return;
            }
          } finally {
            $c$.$destroy();
          }
        }
        
        // Discard the ')', preserving 'Tok' as our result.
        Token RParen/*J*/= new Token();
        $this().LexNonComment(RParen);
        if (RParen.isNot(tok.TokenKind.r_paren)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().getLocForEndOfToken(Tok.getLocation()), diag.err_pp_expected_after)), 
                    Tok.getKind()), tok.TokenKind.r_paren));
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(/*NO_COPY*/LParenLoc, diag.note_matching)), tok.TokenKind.l_paren));
          } finally {
            $c$.$destroy();
          }
        }
        return;
      } else {
        throw new llvm_unreachable("Unknown identifier!");
      }
      // JAVA PERF: use SmallString directly
      OS.flush();
      $this().CreateString(TmpBuffer.$array(), 0, TmpBuffer.size(), Tok, Tok.$getLocation(), Tok.$getLocation());
    } finally {
//      if (OS != null) { OS.$destroy(); }
      if (OS != null) { $this().$releaseExpandBuiltinMacro_OS(OS); }
      if (TmpBuffer != null) { $this().$releaseExpandBuiltinMacro_TmpBuffer(TmpBuffer); }
    }
  }


/// \brief A macro is used, update information about macros that need unused
/// warnings.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::markMacroAsUsed">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1852,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 1790,
   FQN="clang::Preprocessor::markMacroAsUsed", NM="_ZN5clang12Preprocessor15markMacroAsUsedEPNS_9MacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor15markMacroAsUsedEPNS_9MacroInfoE")
  //</editor-fold>
  public void markMacroAsUsed(MacroInfo /*P*/ MI) {
    // If the 'used' status changed, and the macro requires 'unused' warning,
    // remove its SourceLocation from the warn-for-unused-macro locations.
    if (MI.isWarnIfUnused() && !MI.isUsed()) {
      $this().WarnUnusedMacroLocs.erase(MI.getDefinitionLoc());
    }
    MI.setIsUsed(true);
  }

} // END OF class Preprocessor_PPMacroExpansion
