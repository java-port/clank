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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;


/// \brief Records the location of a macro expansion.
//<editor-fold defaultstate="collapsed" desc="clang::MacroExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 158,
 FQN="clang::MacroExpansion", NM="_ZN5clang14MacroExpansionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang14MacroExpansionE")
//</editor-fold>
public class MacroExpansion extends /*public*/ PreprocessedEntity {
  /// \brief The definition of this macro or the name of the macro if it is
  /// a builtin macro.
  private PointerUnion<IdentifierInfo /*P*/ , MacroDefinitionRecord /*P*/ > NameOrDef;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MacroExpansion::MacroExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 164,
   FQN="clang::MacroExpansion::MacroExpansion", NM="_ZN5clang14MacroExpansionC1EPNS_14IdentifierInfoENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang14MacroExpansionC1EPNS_14IdentifierInfoENS_11SourceRangeE")
  //</editor-fold>
  public MacroExpansion(IdentifierInfo /*P*/ BuiltinName, SourceRange Range) {
    // : PreprocessedEntity(MacroExpansionKind, Range), NameOrDef(BuiltinName) 
    //START JInit
    super(EntityKind.MacroExpansionKind, /*NO_COPY*/Range);
    this.NameOrDef = new PointerUnion<IdentifierInfo /*P*/ , MacroDefinitionRecord /*P*/ >(JD$T.INSTANCE, IdentifierInfo /*P*/ .class, BuiltinName);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroExpansion::MacroExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 168,
   FQN="clang::MacroExpansion::MacroExpansion", NM="_ZN5clang14MacroExpansionC1EPNS_21MacroDefinitionRecordENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang14MacroExpansionC1EPNS_21MacroDefinitionRecordENS_11SourceRangeE")
  //</editor-fold>
  public MacroExpansion(MacroDefinitionRecord /*P*/ Definition, SourceRange Range) {
    // : PreprocessedEntity(MacroExpansionKind, Range), NameOrDef(Definition) 
    //START JInit
    super(EntityKind.MacroExpansionKind, /*NO_COPY*/Range);
    this.NameOrDef = new PointerUnion<IdentifierInfo /*P*/ , MacroDefinitionRecord /*P*/ >(JD$T1.INSTANCE, MacroDefinitionRecord /*P*/ .class, Definition);
    //END JInit
  }

  
  /// \brief True if it is a builtin macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroExpansion::isBuiltinMacro">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 173,
   FQN="clang::MacroExpansion::isBuiltinMacro", NM="_ZNK5clang14MacroExpansion14isBuiltinMacroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang14MacroExpansion14isBuiltinMacroEv")
  //</editor-fold>
  public boolean isBuiltinMacro() /*const*/ {
    return (NameOrDef.is(IdentifierInfo.class /*P*/ ) != 0);
  }

  
  /// \brief The name of the macro being expanded.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroExpansion::getName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 176,
   FQN="clang::MacroExpansion::getName", NM="_ZNK5clang14MacroExpansion7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang14MacroExpansion7getNameEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getName() /*const*/ {
    {
      MacroDefinitionRecord /*P*/ Def = getDefinition();
      if ((Def != null)) {
        return Def.getName();
      }
    }
    return NameOrDef.get(IdentifierInfo.class /*P*/);
  }

  
  /// \brief The definition of the macro being expanded. May return null if
  /// this is a builtin macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroExpansion::getDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 184,
   FQN="clang::MacroExpansion::getDefinition", NM="_ZNK5clang14MacroExpansion13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang14MacroExpansion13getDefinitionEv")
  //</editor-fold>
  public MacroDefinitionRecord /*P*/ getDefinition() /*const*/ {
    return NameOrDef.dyn_cast(MacroDefinitionRecord.class /*P*/ );
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroExpansion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 189,
   FQN="clang::MacroExpansion::classof", NM="_ZN5clang14MacroExpansion7classofEPKNS_18PreprocessedEntityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang14MacroExpansion7classofEPKNS_18PreprocessedEntityE")
  //</editor-fold>
  public static boolean classof(/*const*/ PreprocessedEntity /*P*/ PE) {
    return PE.getEntityKind() == EntityKind.MacroExpansionKind;
  }

  
  public String toString() {
    return "" + "NameOrDef=" + NameOrDef // NOI18N
              + super.toString(); // NOI18N
  }
}
