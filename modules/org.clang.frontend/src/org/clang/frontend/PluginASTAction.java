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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.frontend.*;

//<editor-fold defaultstate="collapsed" desc="clang::PluginASTAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 238,
 FQN="clang::PluginASTAction", NM="_ZN5clang15PluginASTActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/plugin/ClangTidyPlugin.cpp -nm=_ZN5clang15PluginASTActionE")
//</editor-fold>
public abstract class PluginASTAction extends /*public*/ ASTFrontendAction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::PluginASTAction::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 560,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 542,
   FQN="clang::PluginASTAction::anchor", NM="_ZN5clang15PluginASTAction6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang15PluginASTAction6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PluginASTAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 241,
   FQN="clang::PluginASTAction::CreateASTConsumer", NM="_ZN5clang15PluginASTAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/plugin/ClangTidyPlugin.cpp -nm=_ZN5clang15PluginASTAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override public abstract std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ CI, 
                   StringRef InFile)/* override*//* = 0*/;

  
  /// \brief Parse the given plugin command line arguments.
  ///
  /// \param CI - The compiler instance, for use in reporting diagnostics.
  /// \return True if the parsing succeeded; otherwise the plugin will be
  /// destroyed and no action run. The plugin is responsible for using the
  /// CompilerInstance's Diagnostic object to report errors.
  //<editor-fold defaultstate="collapsed" desc="clang::PluginASTAction::ParseArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 250,
   FQN="clang::PluginASTAction::ParseArgs", NM="_ZN5clang15PluginASTAction9ParseArgsERKNS_16CompilerInstanceERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/plugin/ClangTidyPlugin.cpp -nm=_ZN5clang15PluginASTAction9ParseArgsERKNS_16CompilerInstanceERKSt6vectorISsSaISsEE")
  //</editor-fold>
  public abstract /*virtual*/ boolean ParseArgs(/*const*/ CompilerInstance /*&*/ CI, 
           /*const*/std.vectorString/*&*/ arg)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::PluginASTAction::ActionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 253,
   FQN="clang::PluginASTAction::ActionType", NM="_ZN5clang15PluginASTAction10ActionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/plugin/ClangTidyPlugin.cpp -nm=_ZN5clang15PluginASTAction10ActionTypeE")
  //</editor-fold>
  public enum ActionType implements Native.ComparableLower {
    Cmdline(0), ///< Action is determined by the cc1 command-line
    ReplaceAction(Cmdline.getValue() + 1), ///< Replace the main action
    AddBeforeMainAction(ReplaceAction.getValue() + 1), ///< Execute the action before the main action
    AddAfterMainAction(AddBeforeMainAction.getValue() + 1); ///< Execute the action after the main action

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ActionType valueOf(int val) {
      ActionType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ActionType[] VALUES;
      private static final ActionType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ActionType kind : ActionType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ActionType[min < 0 ? (1-min) : 0];
        VALUES = new ActionType[max >= 0 ? (1+max) : 0];
        for (ActionType kind : ActionType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ActionType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ActionType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ActionType)obj).value);}
    //</editor-fold>
  };
  /// \brief Get the action type for this plugin
  ///
  /// \return The action type. If the type is Cmdline then by default the
  /// plugin does nothing and what it does is determined by the cc1
  /// command-line.
  //<editor-fold defaultstate="collapsed" desc="clang::PluginASTAction::getActionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 264,
   FQN="clang::PluginASTAction::getActionType", NM="_ZN5clang15PluginASTAction13getActionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/plugin/ClangTidyPlugin.cpp -nm=_ZN5clang15PluginASTAction13getActionTypeEv")
  //</editor-fold>
  public /*virtual*/ ActionType getActionType() {
    return ActionType.Cmdline;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PluginASTAction::~PluginASTAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 238,
   FQN="clang::PluginASTAction::~PluginASTAction", NM="_ZN5clang15PluginASTActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/plugin/ClangTidyPlugin.cpp -nm=_ZN5clang15PluginASTActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PluginASTAction::PluginASTAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 238,
   FQN="clang::PluginASTAction::PluginASTAction", NM="_ZN5clang15PluginASTActionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/plugin/ClangTidyPlugin.cpp -nm=_ZN5clang15PluginASTActionC1Ev")
  //</editor-fold>
  public /*inline*/ PluginASTAction() {
    // : ASTFrontendAction() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
