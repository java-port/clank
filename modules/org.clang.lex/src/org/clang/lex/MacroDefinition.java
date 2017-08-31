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

import org.clang.lex.java.LexFunctionPointers.MacroInfo2Void;
import org.clank.support.Converted;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.Native;
import org.clank.support.Native.NativePOD;
import org.llvm.adt.aliases.ArrayRef;


/// \brief A description of the current definition of a macro.
///
/// The definition of a macro comprises a set of (at least one) defining
/// entities, which are either local MacroDirectives or imported ModuleMacros.
//<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition">
@Converted(kind = Converted.Kind.MANUAL/*POD*/,
 optimized = Converted.Optimization.VALUE_TYPE/*unfolded field*/,       
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 563,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 137,
 FQN="clang::MacroDefinition", NM="_ZN5clang15MacroDefinitionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang15MacroDefinitionE")
//</editor-fold>
public class MacroDefinition implements NativePOD<MacroDefinition>, Native.Native$Bool  {
  // JAVA: field was unfolded below to prevent intensive objects allocations
//  private PointerBoolPair<DefMacroDirective /*P*/> LatestLocalAndAmbiguous;
  private final ArrayRef<ModuleMacro /*P*/ > ModuleMacros;
  public static final MacroDefinition EMPTY = new MacroDefinition();
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::MacroDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 568,
   FQN="clang::MacroDefinition::MacroDefinition", NM="_ZN5clang15MacroDefinitionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang15MacroDefinitionC1Ev")
  //</editor-fold>
  public MacroDefinition() {
    /* : LatestLocalAndAmbiguous(), ModuleMacros()*/ 
    //START JInit
    this.LatestLocalAndAmbiguous$Ptr = null;
    this.LatestLocalAndAmbiguous$Bool = false;
    this.ModuleMacros = ArrayRef.<ModuleMacro /*P*/ >None();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::MacroDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 569,
   FQN="clang::MacroDefinition::MacroDefinition", NM="_ZN5clang15MacroDefinitionC1EPNS_17DefMacroDirectiveEN4llvm8ArrayRefIPNS_11ModuleMacroEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang15MacroDefinitionC1EPNS_17DefMacroDirectiveEN4llvm8ArrayRefIPNS_11ModuleMacroEEEb")
  //</editor-fold>
  public MacroDefinition(DefMacroDirective /*P*/ MD, ArrayRef<ModuleMacro /*P*/ > MMs, 
      boolean IsAmbiguous) {
    /* : LatestLocalAndAmbiguous(MD, IsAmbiguous), ModuleMacros(MMs)*/ 
    //START JInit
    this.LatestLocalAndAmbiguous$Ptr = MD;
    this.LatestLocalAndAmbiguous$Bool = IsAmbiguous;
    this.ModuleMacros = MMs == ArrayRef.<ModuleMacro /*P*/ >None() ? MMs : new ArrayRef<ModuleMacro /*P*/ >(MMs);
    //END JInit
  }

  
  /// \brief Determine whether there is a definition of this macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 574,
   FQN="clang::MacroDefinition::operator bool", NM="_ZNK5clang15MacroDefinitioncvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang15MacroDefinitioncvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return (getLocalDirective() != null) || !ModuleMacros.empty();
  }

  
  /// \brief Get the MacroInfo that should be used for this definition.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::getMacroInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 579,
   FQN="clang::MacroDefinition::getMacroInfo", NM="_ZNK5clang15MacroDefinition12getMacroInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang15MacroDefinition12getMacroInfoEv")
  //</editor-fold>
  public MacroInfo /*P*/ getMacroInfo() /*const*/ {
    if (!ModuleMacros.empty()) {
      return ModuleMacros.back().getMacroInfo();
    }
    {
      DefMacroDirective /*P*/ MD = getLocalDirective();
      if ((MD != null)) {
        return MD.getMacroInfo();
      }
    }
    return null;
  }

  
  /// \brief \c true if the definition is ambiguous, \c false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::isAmbiguous">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,       
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 588,
   FQN="clang::MacroDefinition::isAmbiguous", NM="_ZNK5clang15MacroDefinition11isAmbiguousEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang15MacroDefinition11isAmbiguousEv")
  //</editor-fold>
  public boolean isAmbiguous() /*const*/ {
    return LatestLocalAndAmbiguous$Bool;
  }

  
  /// \brief Get the latest non-imported, non-\#undef'd macro definition
  /// for this macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::getLocalDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,       
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 592,
   FQN="clang::MacroDefinition::getLocalDirective", NM="_ZNK5clang15MacroDefinition17getLocalDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang15MacroDefinition17getLocalDirectiveEv")
  //</editor-fold>
  public DefMacroDirective /*P*/ getLocalDirective() /*const*/ {
    return LatestLocalAndAmbiguous$Ptr;
  }

  
  /// \brief Get the active module macros for this macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::getModuleMacros">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 597,
   FQN="clang::MacroDefinition::getModuleMacros", NM="_ZNK5clang15MacroDefinition15getModuleMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang15MacroDefinition15getModuleMacrosEv")
  //</editor-fold>
  public ArrayRef<ModuleMacro /*P*/ > getModuleMacros() /*const*/ {
    return ModuleMacros;
  }

  
  /*template <typename Fn> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::forAllDefinitions">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 599,
   FQN="clang::MacroDefinition::forAllDefinitions", NM="Tpl__ZNK5clang15MacroDefinition17forAllDefinitionsET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=Tpl__ZNK5clang15MacroDefinition17forAllDefinitionsET_")
  //</editor-fold>
  public </*typename*/ Fn extends MacroInfo2Void/*MANUAL_COMPILATION*/> void forAllDefinitions(Fn F) /*const*/ {
    {
      DefMacroDirective /*P*/ MD = getLocalDirective();
      if ((MD != null)) {
        F.$call(MD.getMacroInfo());
      }
    }
    for (ModuleMacro /*P*/ MM : getModuleMacros())  {
      F.$call(MM.getMacroInfo());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::MacroDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 563,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 137,
   FQN="clang::MacroDefinition::MacroDefinition", NM="_ZN5clang15MacroDefinitionC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang15MacroDefinitionC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MacroDefinition(/*const*/ MacroDefinition /*&*/ $Prm0) {
    /* : LatestLocalAndAmbiguous(.LatestLocalAndAmbiguous), ModuleMacros(.ModuleMacros)*/ 
    //START JInit
    this.LatestLocalAndAmbiguous$Ptr = $Prm0.LatestLocalAndAmbiguous$Ptr;
    this.LatestLocalAndAmbiguous$Bool = $Prm0.LatestLocalAndAmbiguous$Bool;
    this.ModuleMacros = $Prm0.ModuleMacros == ArrayRef.<ModuleMacro /*P*/ >None() ? $Prm0.ModuleMacros : new ArrayRef<ModuleMacro /*P*/ >($Prm0.ModuleMacros);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroDefinition::MacroDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 563,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 137,
   FQN="clang::MacroDefinition::MacroDefinition", NM="_ZN5clang15MacroDefinitionC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang15MacroDefinitionC1EOS0_")
  //</editor-fold>
  public /*inline*/ MacroDefinition(JD$Move _dparam, MacroDefinition /*&&*/$Prm0) {
    /* : LatestLocalAndAmbiguous(static_cast<MacroDefinition &&>().LatestLocalAndAmbiguous), ModuleMacros(static_cast<MacroDefinition &&>().ModuleMacros)*/ 
    //START JInit
    this.LatestLocalAndAmbiguous$Ptr = $Prm0.LatestLocalAndAmbiguous$Ptr;
    this.LatestLocalAndAmbiguous$Bool = $Prm0.LatestLocalAndAmbiguous$Bool;
    this.ModuleMacros = $Prm0.ModuleMacros == ArrayRef.<ModuleMacro /*P*/ >None() ? $Prm0.ModuleMacros : new ArrayRef<ModuleMacro /*P*/ >(JD$Move.INSTANCE, $Prm0.ModuleMacros);
    //END JInit
  }

  private DefMacroDirective /*P*/ LatestLocalAndAmbiguous$Ptr;
  private boolean LatestLocalAndAmbiguous$Bool;

  @Override
  public MacroDefinition $assign(MacroDefinition value) {
    this.LatestLocalAndAmbiguous$Ptr = value.LatestLocalAndAmbiguous$Ptr;
    this.LatestLocalAndAmbiguous$Bool = value.LatestLocalAndAmbiguous$Bool;
    this.ModuleMacros.$assign(value.ModuleMacros);
    return this;
  }

  @Override
  public MacroDefinition clone() {
    return new MacroDefinition(this);
  }

  @Override
  public boolean $eq(MacroDefinition other) {
    return this.LatestLocalAndAmbiguous$Bool == other.LatestLocalAndAmbiguous$Bool  
            && this.LatestLocalAndAmbiguous$Ptr == other.LatestLocalAndAmbiguous$Ptr  
            && this.ModuleMacros.$eq(other.ModuleMacros);
  }
  
  public String toString() {
    return "" + "LatestLocalAndAmbiguous={" + LatestLocalAndAmbiguous$Bool + "|" + LatestLocalAndAmbiguous$Ptr // NOI18N
              + "}, ModuleMacros=" + ModuleMacros; // NOI18N
  }
  
}
