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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;


/// \brief Represents a macro directive exported by a module.
///
/// There's an instance of this class for every macro #define or #undef that is
/// the final directive for a macro name within a module. These entities also
/// represent the macro override graph.
///
/// These are stored in a FoldingSet in the preprocessor.
//<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 497,
 FQN="clang::ModuleMacro", NM="_ZN5clang11ModuleMacroE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang11ModuleMacroE")
//</editor-fold>
public class ModuleMacro extends /*public*/ FoldingSetImpl.NodeImpl implements FoldingSetImpl.Node {
  
  /// The name defined by the macro.
  /*friend*/protected IdentifierInfo /*P*/ II;
  /// The body of the #define, or nullptr if this is a #undef.
  private MacroInfo /*P*/ Macro;
  /// The module that exports this macro.
  private Module /*P*/ OwningModule;
  /// The number of module macros that override this one.
  /*friend*//*private*/ /*uint*/int NumOverriddenBy;
  /// The number of modules whose macros are directly overridden by this one.
  private /*uint*/int NumOverrides;
  // ModuleMacro *OverriddenMacros[NumOverrides];
  /*friend  class Preprocessor*/
  
  // JAVA: this+1
  private final type$ptr<ModuleMacro /*P*/ > Overrides; /* MANUAL_SEMANTIC */
  /*friend*/ ModuleMacro() {// for DenseMapInfo
    this.Overrides = null;
  } 
  
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::ModuleMacro">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 512,
   FQN="clang::ModuleMacro::ModuleMacro", NM="_ZN5clang11ModuleMacroC1EPNS_6ModuleEPNS_14IdentifierInfoEPNS_9MacroInfoEN4llvm8ArrayRefIPS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang11ModuleMacroC1EPNS_6ModuleEPNS_14IdentifierInfoEPNS_9MacroInfoEN4llvm8ArrayRefIPS0_EE")
  //</editor-fold>
  private ModuleMacro(Module /*P*/ OwningModule, IdentifierInfo /*P*/ II, MacroInfo /*P*/ Macro, 
      ArrayRef<ModuleMacro /*P*/ > Overrides) {
    /* : FoldingSetNode(), II(II), Macro(Macro), OwningModule(OwningModule), NumOverriddenBy(0), NumOverrides(Overrides.size())*/ 
    //START JInit
    super();
    this.II = II;
    this.Macro = Macro;
    this.OwningModule = OwningModule;
    this.NumOverriddenBy = 0;
    this.NumOverrides = Overrides.size();
    //END JInit
    // JAVA: 
    this.Overrides = $tryConstClone(Overrides.begin());
//    std.copy(Overrides.begin(), Overrides.end(), 
//        reinterpret_cast(ModuleMacro /*P*/ /*P*/ .class, this + 1));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", line = 238,
   FQN="clang::ModuleMacro::create", NM="_ZN5clang11ModuleMacro6createERNS_12PreprocessorEPNS_6ModuleEPNS_14IdentifierInfoEPNS_9MacroInfoEN4llvm8ArrayRefIPS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang11ModuleMacro6createERNS_12PreprocessorEPNS_6ModuleEPNS_14IdentifierInfoEPNS_9MacroInfoEN4llvm8ArrayRefIPS0_EE")
  //</editor-fold>
  public static ModuleMacro /*P*/ create(Preprocessor /*&*/ PP, Module /*P*/ OwningModule, 
        IdentifierInfo /*P*/ II, MacroInfo /*P*/ Macro, 
        ArrayRef<ModuleMacro /*P*/ > Overrides) {
    // JAVA: 
//    Object/*void P*/ Mem = $tryClone(PP.getPreprocessorAllocator().Allocate(sizeof(ModuleMacro) + sizeof(ModuleMacro /*P*/ ) * Overrides.size(), 
//        llvm.alignOf<ModuleMacro>()));
    return /*FIXME:*//*new (Mem)*/ new ModuleMacro(OwningModule, II, Macro, new ArrayRef<ModuleMacro /*P*/ >(Overrides));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 525,
   FQN="clang::ModuleMacro::Profile", NM="_ZNK5clang11ModuleMacro7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang11ModuleMacro7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(FoldingSetNodeID /*&*/ ID) /*const*/ {
    Profile(ID, OwningModule, II);
    return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 528,
   FQN="clang::ModuleMacro::Profile", NM="_ZN5clang11ModuleMacro7ProfileERN4llvm16FoldingSetNodeIDEPNS_6ModuleEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang11ModuleMacro7ProfileERN4llvm16FoldingSetNodeIDEPNS_6ModuleEPNS_14IdentifierInfoE")
  //</editor-fold>
  public static void Profile(FoldingSetNodeID /*&*/ ID, Module /*P*/ OwningModule, 
         IdentifierInfo /*P*/ II) {
    ID.AddPointer(OwningModule);
    ID.AddPointer(II);
  }

  
  /// Get the ID of the module that exports this macro.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::getOwningModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 535,
   FQN="clang::ModuleMacro::getOwningModule", NM="_ZNK5clang11ModuleMacro15getOwningModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang11ModuleMacro15getOwningModuleEv")
  //</editor-fold>
  public Module /*P*/ getOwningModule() /*const*/ {
    return OwningModule;
  }

  
  /// Get definition for this exported #define, or nullptr if this
  /// represents a #undef.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::getMacroInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 539,
   FQN="clang::ModuleMacro::getMacroInfo", NM="_ZNK5clang11ModuleMacro12getMacroInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang11ModuleMacro12getMacroInfoEv")
  //</editor-fold>
  public MacroInfo /*P*/ getMacroInfo() /*const*/ {
    return Macro;
  }

  
  /// Iterators over the overridden module IDs.
  /// \{
  /*typedef ModuleMacro *const *overrides_iterator*/
//  public final class overrides_iterator extends ModuleMacro /*P*/ /*const*/ /*P*/ { };
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::overrides_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 544,
   FQN="clang::ModuleMacro::overrides_begin", NM="_ZNK5clang11ModuleMacro15overrides_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang11ModuleMacro15overrides_beginEv")
  //</editor-fold>
  public type$ptr<ModuleMacro> overrides_begin() /*const*/ {
//    return reinterpret_cast(ModuleMacro.class, this + 1);
    return this.Overrides;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::overrides_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 547,
   FQN="clang::ModuleMacro::overrides_end", NM="_ZNK5clang11ModuleMacro13overrides_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang11ModuleMacro13overrides_endEv")
  //</editor-fold>
  public type$ptr<ModuleMacro> overrides_end() /*const*/ {
//    return overrides_begin() + NumOverrides;
    return this.Overrides.$add(NumOverrides);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::overrides">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 550,
   FQN="clang::ModuleMacro::overrides", NM="_ZNK5clang11ModuleMacro9overridesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang11ModuleMacro9overridesEv")
  //</editor-fold>
  public ArrayRef<ModuleMacro /*P*/ > overrides() /*const*/ {
    return llvm.makeArrayRef(overrides_begin(), overrides_end());
  }

  /// \}
  
  /// Get the number of macros that override this one.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMacro::getNumOverridingMacros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 556,
   FQN="clang::ModuleMacro::getNumOverridingMacros", NM="_ZNK5clang11ModuleMacro22getNumOverridingMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang11ModuleMacro22getNumOverridingMacrosEv")
  //</editor-fold>
  public /*uint*/int getNumOverridingMacros() /*const*/ {
    return NumOverriddenBy;
  }

  
  public String toString() {
    return "" + "II=" + II // NOI18N
              + ", Macro=" + Macro // NOI18N
              + ", OwningModule=" + OwningModule // NOI18N
              + ", NumOverriddenBy=" + NumOverriddenBy // NOI18N
              + ", NumOverrides=" + NumOverrides // NOI18N
              + super.toString(); // NOI18N
  }
}
