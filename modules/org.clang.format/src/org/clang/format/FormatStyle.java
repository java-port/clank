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

package org.clang.format;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.clank.support.Native.NativePOD;
import org.clank.support.aliases.*;


/// \brief The ``FormatStyle`` is used to configure the formatting to follow
/// specific guidelines.
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 46,
 FQN="clang::format::FormatStyle", NM="_ZN5clang6format11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyleE")
//</editor-fold>
public class/*struct*/ FormatStyle implements Destructors.ClassWithDestructor, Native.NativeComparable<FormatStyle>, NativePOD<FormatStyle> {
  /// \brief The extra indent or outdent of access modifiers, e.g. ``public:``.
  public int AccessModifierOffset;

  /// \brief Different styles for aligning after open brackets.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::BracketAlignmentStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 51,
   FQN="clang::format::FormatStyle::BracketAlignmentStyle", NM="_ZN5clang6format11FormatStyle21BracketAlignmentStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle21BracketAlignmentStyleE")
  //</editor-fold>
  public enum BracketAlignmentStyle implements Native.NativeUIntEnum {
    /// \brief Align parameters on the open bracket, e.g.:
    /// \code
    ///   someLongFunction(argument1,
    ///                    argument2);
    /// \endcode
    BAS_Align(0),
    /// \brief Don't align, instead use ``ContinuationIndentWidth``, e.g.:
    /// \code
    ///   someLongFunction(argument1,
    ///       argument2);
    /// \endcode
    BAS_DontAlign(BAS_Align.getValue() + 1),
    /// \brief Always break after an open bracket, if the parameters don't fit
    /// on a single line, e.g.:
    /// \code
    ///   someLongFunction(
    ///       argument1, argument2);
    /// \endcode
    BAS_AlwaysBreak(BAS_DontAlign.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BracketAlignmentStyle valueOf(int val) {
      BracketAlignmentStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BracketAlignmentStyle[] VALUES;
      private static final BracketAlignmentStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BracketAlignmentStyle kind : BracketAlignmentStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BracketAlignmentStyle[min < 0 ? (1-min) : 0];
        VALUES = new BracketAlignmentStyle[max >= 0 ? (1+max) : 0];
        for (BracketAlignmentStyle kind : BracketAlignmentStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private BracketAlignmentStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief If ``true``, horizontally aligns arguments after an open bracket.
  ///
  /// This applies to round brackets (parentheses), angle brackets and square
  /// brackets.
  public BracketAlignmentStyle AlignAfterOpenBracket = BracketAlignmentStyle.BAS_Align;
  
  /// \brief If ``true``, aligns consecutive assignments.
  ///
  /// This will align the assignment operators of consecutive lines. This
  /// will result in formattings like
  /// \code
  ///   int aaaa = 12;
  ///   int b    = 23;
  ///   int ccc  = 23;
  /// \endcode
  public boolean AlignConsecutiveAssignments;
  
  /// \brief If ``true``, aligns consecutive declarations.
  ///
  /// This will align the declaration names of consecutive lines. This
  /// will result in formattings like
  /// \code
  ///   int         aaaa = 12;
  ///   float       b = 23;
  ///   std::string ccc = 23;
  /// \endcode
  public boolean AlignConsecutiveDeclarations;
  
  /// \brief If ``true``, aligns escaped newlines as far left as possible.
  /// Otherwise puts them into the right-most column.
  public boolean AlignEscapedNewlinesLeft;
  
  /// \brief If ``true``, horizontally align operands of binary and ternary
  /// expressions.
  ///
  /// Specifically, this aligns operands of a single expression that needs to be
  /// split over multiple lines, e.g.:
  /// \code
  ///   int aaa = bbbbbbbbbbbbbbb +
  ///             ccccccccccccccc;
  /// \endcode
  public boolean AlignOperands;
  
  /// \brief If ``true``, aligns trailing comments.
  public boolean AlignTrailingComments;
  
  /// \brief Allow putting all parameters of a function declaration onto
  /// the next line even if ``BinPackParameters`` is ``false``.
  public boolean AllowAllParametersOfDeclarationOnNextLine;
  
  /// \brief Allows contracting simple braced statements to a single line.
  ///
  /// E.g., this allows ``if (a) { return; }`` to be put on a single line.
  public boolean AllowShortBlocksOnASingleLine;
  
  /// \brief If ``true``, short case labels will be contracted to a single line.
  public boolean AllowShortCaseLabelsOnASingleLine;
  
  /// \brief Different styles for merging short functions containing at most one
  /// statement.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::ShortFunctionStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 133,
   FQN="clang::format::FormatStyle::ShortFunctionStyle", NM="_ZN5clang6format11FormatStyle18ShortFunctionStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle18ShortFunctionStyleE")
  //</editor-fold>
  public enum ShortFunctionStyle implements Native.NativeUIntEnum {
    /// \brief Never merge functions into a single line.
    SFS_None(0),
    /// \brief Only merge empty functions.
    SFS_Empty(SFS_None.getValue() + 1),
    /// \brief Only merge functions defined inside a class. Implies "empty".
    SFS_Inline(SFS_Empty.getValue() + 1),
    /// \brief Merge all functions fitting on a single line.
    SFS_All(SFS_Inline.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ShortFunctionStyle valueOf(int val) {
      ShortFunctionStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ShortFunctionStyle[] VALUES;
      private static final ShortFunctionStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ShortFunctionStyle kind : ShortFunctionStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ShortFunctionStyle[min < 0 ? (1-min) : 0];
        VALUES = new ShortFunctionStyle[max >= 0 ? (1+max) : 0];
        for (ShortFunctionStyle kind : ShortFunctionStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ShortFunctionStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Dependent on the value, ``int f() { return 0; }`` can be put on a
  /// single line.
  public ShortFunctionStyle AllowShortFunctionsOnASingleLine = ShortFunctionStyle.SFS_None;
  
  /// \brief If ``true``, ``if (a) return;`` can be put on a single line.
  public boolean AllowShortIfStatementsOnASingleLine;
  
  /// \brief If ``true``, ``while (true) continue;`` can be put on a single
  /// line.
  public boolean AllowShortLoopsOnASingleLine;
  
  /// \brief Different ways to break after the function definition return type.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::DefinitionReturnTypeBreakingStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 156,
   FQN="clang::format::FormatStyle::DefinitionReturnTypeBreakingStyle", NM="_ZN5clang6format11FormatStyle33DefinitionReturnTypeBreakingStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle33DefinitionReturnTypeBreakingStyleE")
  //</editor-fold>
  public enum DefinitionReturnTypeBreakingStyle implements Native.NativeUIntEnum {
    /// Break after return type automatically.
    /// ``PenaltyReturnTypeOnItsOwnLine`` is taken into account.
    DRTBS_None(0),
    /// Always break after the return type.
    DRTBS_All(DRTBS_None.getValue() + 1),
    /// Always break after the return types of top-level functions.
    DRTBS_TopLevel(DRTBS_All.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DefinitionReturnTypeBreakingStyle valueOf(int val) {
      DefinitionReturnTypeBreakingStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DefinitionReturnTypeBreakingStyle[] VALUES;
      private static final DefinitionReturnTypeBreakingStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DefinitionReturnTypeBreakingStyle kind : DefinitionReturnTypeBreakingStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DefinitionReturnTypeBreakingStyle[min < 0 ? (1-min) : 0];
        VALUES = new DefinitionReturnTypeBreakingStyle[max >= 0 ? (1+max) : 0];
        for (DefinitionReturnTypeBreakingStyle kind : DefinitionReturnTypeBreakingStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private DefinitionReturnTypeBreakingStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Different ways to break after the function definition or
  /// declaration return type.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::ReturnTypeBreakingStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 168,
   FQN="clang::format::FormatStyle::ReturnTypeBreakingStyle", NM="_ZN5clang6format11FormatStyle23ReturnTypeBreakingStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle23ReturnTypeBreakingStyleE")
  //</editor-fold>
  public enum ReturnTypeBreakingStyle implements Native.NativeUIntEnum {
    /// Break after return type automatically.
    /// ``PenaltyReturnTypeOnItsOwnLine`` is taken into account.
    RTBS_None(0),
    /// Always break after the return type.
    RTBS_All(RTBS_None.getValue() + 1),
    /// Always break after the return types of top-level functions.
    RTBS_TopLevel(RTBS_All.getValue() + 1),
    /// Always break after the return type of function definitions.
    RTBS_AllDefinitions(RTBS_TopLevel.getValue() + 1),
    /// Always break after the return type of top-level definitions.
    RTBS_TopLevelDefinitions(RTBS_AllDefinitions.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ReturnTypeBreakingStyle valueOf(int val) {
      ReturnTypeBreakingStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ReturnTypeBreakingStyle[] VALUES;
      private static final ReturnTypeBreakingStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ReturnTypeBreakingStyle kind : ReturnTypeBreakingStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ReturnTypeBreakingStyle[min < 0 ? (1-min) : 0];
        VALUES = new ReturnTypeBreakingStyle[max >= 0 ? (1+max) : 0];
        for (ReturnTypeBreakingStyle kind : ReturnTypeBreakingStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ReturnTypeBreakingStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief The function definition return type breaking style to use.  This
  /// option is deprecated and is retained for backwards compatibility.
  public DefinitionReturnTypeBreakingStyle AlwaysBreakAfterDefinitionReturnType = DefinitionReturnTypeBreakingStyle.DRTBS_None;
  
  /// \brief The function declaration return type breaking style to use.
  public ReturnTypeBreakingStyle AlwaysBreakAfterReturnType = ReturnTypeBreakingStyle.RTBS_None;
  
  /// \brief If ``true``, always break before multiline string literals.
  ///
  /// This flag is mean to make cases where there are multiple multiline strings
  /// in a file look more consistent. Thus, it will only take effect if wrapping
  /// the string at that point leads to it being indented
  /// ``ContinuationIndentWidth`` spaces from the start of the line.
  public boolean AlwaysBreakBeforeMultilineStrings;
  
  /// \brief If ``true``, always break after the ``template<...>`` of a template
  /// declaration.
  public boolean AlwaysBreakTemplateDeclarations;
  
  /// \brief If ``false``, a function call's arguments will either be all on the
  /// same line or will have one line each.
  public boolean BinPackArguments;
  
  /// \brief If ``false``, a function declaration's or function definition's
  /// parameters will either all be on the same line or will have one line each.
  public boolean BinPackParameters;
  
  /// \brief The style of breaking before or after binary operators.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::BinaryOperatorStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 210,
   FQN="clang::format::FormatStyle::BinaryOperatorStyle", NM="_ZN5clang6format11FormatStyle19BinaryOperatorStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle19BinaryOperatorStyleE")
  //</editor-fold>
  public enum BinaryOperatorStyle implements Native.NativeUIntEnum {
    /// Break after operators.
    BOS_None(0),
    /// Break before operators that aren't assignments.
    BOS_NonAssignment(BOS_None.getValue() + 1),
    /// Break before operators.
    BOS_All(BOS_NonAssignment.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BinaryOperatorStyle valueOf(int val) {
      BinaryOperatorStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BinaryOperatorStyle[] VALUES;
      private static final BinaryOperatorStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BinaryOperatorStyle kind : BinaryOperatorStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BinaryOperatorStyle[min < 0 ? (1-min) : 0];
        VALUES = new BinaryOperatorStyle[max >= 0 ? (1+max) : 0];
        for (BinaryOperatorStyle kind : BinaryOperatorStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private BinaryOperatorStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief The way to wrap binary operators.
  public BinaryOperatorStyle BreakBeforeBinaryOperators = BinaryOperatorStyle.BOS_None;
  
  /// \brief Different ways to attach braces to their surrounding context.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::BraceBreakingStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 223,
   FQN="clang::format::FormatStyle::BraceBreakingStyle", NM="_ZN5clang6format11FormatStyle18BraceBreakingStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle18BraceBreakingStyleE")
  //</editor-fold>
  public enum BraceBreakingStyle implements Native.NativeUIntEnum {
    /// Always attach braces to surrounding context.
    BS_Attach(0),
    /// Like ``Attach``, but break before braces on function, namespace and
    /// class definitions.
    BS_Linux(BS_Attach.getValue() + 1),
    /// Like ``Attach``, but break before braces on enum, function, and record
    /// definitions.
    BS_Mozilla(BS_Linux.getValue() + 1),
    /// Like ``Attach``, but break before function definitions, ``catch``, and
    /// ``else``.
    BS_Stroustrup(BS_Mozilla.getValue() + 1),
    /// Always break before braces.
    BS_Allman(BS_Stroustrup.getValue() + 1),
    /// Always break before braces and add an extra level of indentation to
    /// braces of control statements, not to those of class, function
    /// or other definitions.
    BS_GNU(BS_Allman.getValue() + 1),
    /// Like ``Attach``, but break before functions.
    BS_WebKit(BS_GNU.getValue() + 1),
    /// Configure each individual brace in `BraceWrapping`.
    BS_Custom(BS_WebKit.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BraceBreakingStyle valueOf(int val) {
      BraceBreakingStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BraceBreakingStyle[] VALUES;
      private static final BraceBreakingStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BraceBreakingStyle kind : BraceBreakingStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BraceBreakingStyle[min < 0 ? (1-min) : 0];
        VALUES = new BraceBreakingStyle[max >= 0 ? (1+max) : 0];
        for (BraceBreakingStyle kind : BraceBreakingStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private BraceBreakingStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief The brace breaking style to use.
  public BraceBreakingStyle BreakBeforeBraces = BraceBreakingStyle.BS_Attach;
  
  /// \brief Precise control over the wrapping of braces.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::BraceWrappingFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 251,
   FQN="clang::format::FormatStyle::BraceWrappingFlags", NM="_ZN5clang6format11FormatStyle18BraceWrappingFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle18BraceWrappingFlagsE")
  //</editor-fold>
  public static class/*struct*/ BraceWrappingFlags {
    /// \brief Wrap class definitions.
    public boolean AfterClass;
    /// \brief Wrap control statements (``if``/``for``/``while``/``switch``/..).
    public boolean AfterControlStatement;
    /// \brief Wrap enum definitions.
    public boolean AfterEnum;
    /// \brief Wrap function definitions.
    public boolean AfterFunction;
    /// \brief Wrap namespace definitions.
    public boolean AfterNamespace;
    /// \brief Wrap ObjC definitions (``@autoreleasepool``, interfaces, ..).
    public boolean AfterObjCDeclaration;
    /// \brief Wrap struct definitions.
    public boolean AfterStruct;
    /// \brief Wrap union definitions.
    public boolean AfterUnion;
    /// \brief Wrap before ``catch``.
    public boolean BeforeCatch;
    /// \brief Wrap before ``else``.
    public boolean BeforeElse;
    /// \brief Indent the wrapped braces themselves.
    public boolean IndentBraces;
    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::BraceWrappingFlags::BraceWrappingFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 251,
     FQN="clang::format::FormatStyle::BraceWrappingFlags::BraceWrappingFlags", NM="_ZN5clang6format11FormatStyle18BraceWrappingFlagsC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle18BraceWrappingFlagsC1ERKS2_")
    //</editor-fold>
    public /*inline*/ BraceWrappingFlags(final /*const*/ BraceWrappingFlags /*&*/ $Prm0) {
      // : AfterClass(.AfterClass), AfterControlStatement(.AfterControlStatement), AfterEnum(.AfterEnum), AfterFunction(.AfterFunction), AfterNamespace(.AfterNamespace), AfterObjCDeclaration(.AfterObjCDeclaration), AfterStruct(.AfterStruct), AfterUnion(.AfterUnion), BeforeCatch(.BeforeCatch), BeforeElse(.BeforeElse), IndentBraces(.IndentBraces) 
      //START JInit
      this.AfterClass = $Prm0.AfterClass;
      this.AfterControlStatement = $Prm0.AfterControlStatement;
      this.AfterEnum = $Prm0.AfterEnum;
      this.AfterFunction = $Prm0.AfterFunction;
      this.AfterNamespace = $Prm0.AfterNamespace;
      this.AfterObjCDeclaration = $Prm0.AfterObjCDeclaration;
      this.AfterStruct = $Prm0.AfterStruct;
      this.AfterUnion = $Prm0.AfterUnion;
      this.BeforeCatch = $Prm0.BeforeCatch;
      this.BeforeElse = $Prm0.BeforeElse;
      this.IndentBraces = $Prm0.IndentBraces;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::BraceWrappingFlags::BraceWrappingFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 251,
     FQN="clang::format::FormatStyle::BraceWrappingFlags::BraceWrappingFlags", NM="_ZN5clang6format11FormatStyle18BraceWrappingFlagsC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle18BraceWrappingFlagsC1EOS2_")
    //</editor-fold>
    public /*inline*/ BraceWrappingFlags(JD$Move _dparam, final BraceWrappingFlags /*&&*/$Prm0) {
      // : AfterClass(static_cast<BraceWrappingFlags &&>().AfterClass), AfterControlStatement(static_cast<BraceWrappingFlags &&>().AfterControlStatement), AfterEnum(static_cast<BraceWrappingFlags &&>().AfterEnum), AfterFunction(static_cast<BraceWrappingFlags &&>().AfterFunction), AfterNamespace(static_cast<BraceWrappingFlags &&>().AfterNamespace), AfterObjCDeclaration(static_cast<BraceWrappingFlags &&>().AfterObjCDeclaration), AfterStruct(static_cast<BraceWrappingFlags &&>().AfterStruct), AfterUnion(static_cast<BraceWrappingFlags &&>().AfterUnion), BeforeCatch(static_cast<BraceWrappingFlags &&>().BeforeCatch), BeforeElse(static_cast<BraceWrappingFlags &&>().BeforeElse), IndentBraces(static_cast<BraceWrappingFlags &&>().IndentBraces) 
      //START JInit
      this.AfterClass = $Prm0.AfterClass;
      this.AfterControlStatement = $Prm0.AfterControlStatement;
      this.AfterEnum = $Prm0.AfterEnum;
      this.AfterFunction = $Prm0.AfterFunction;
      this.AfterNamespace = $Prm0.AfterNamespace;
      this.AfterObjCDeclaration = $Prm0.AfterObjCDeclaration;
      this.AfterStruct = $Prm0.AfterStruct;
      this.AfterUnion = $Prm0.AfterUnion;
      this.BeforeCatch = $Prm0.BeforeCatch;
      this.BeforeElse = $Prm0.BeforeElse;
      this.IndentBraces = $Prm0.IndentBraces;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::BraceWrappingFlags::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 251,
     FQN="clang::format::FormatStyle::BraceWrappingFlags::operator=", NM="_ZN5clang6format11FormatStyle18BraceWrappingFlagsaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle18BraceWrappingFlagsaSERKS2_")
    //</editor-fold>
    public /*inline*/ BraceWrappingFlags /*&*/ $assign(final /*const*/ BraceWrappingFlags /*&*/ $Prm0) {
      this.AfterClass = $Prm0.AfterClass;
      this.AfterControlStatement = $Prm0.AfterControlStatement;
      this.AfterEnum = $Prm0.AfterEnum;
      this.AfterFunction = $Prm0.AfterFunction;
      this.AfterNamespace = $Prm0.AfterNamespace;
      this.AfterObjCDeclaration = $Prm0.AfterObjCDeclaration;
      this.AfterStruct = $Prm0.AfterStruct;
      this.AfterUnion = $Prm0.AfterUnion;
      this.BeforeCatch = $Prm0.BeforeCatch;
      this.BeforeElse = $Prm0.BeforeElse;
      this.IndentBraces = $Prm0.IndentBraces;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::BraceWrappingFlags::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 251,
     FQN="clang::format::FormatStyle::BraceWrappingFlags::operator=", NM="_ZN5clang6format11FormatStyle18BraceWrappingFlagsaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle18BraceWrappingFlagsaSEOS2_")
    //</editor-fold>
    public /*inline*/ BraceWrappingFlags /*&*/ $assignMove(final BraceWrappingFlags /*&&*/$Prm0) {
      this.AfterClass = $Prm0.AfterClass;
      this.AfterControlStatement = $Prm0.AfterControlStatement;
      this.AfterEnum = $Prm0.AfterEnum;
      this.AfterFunction = $Prm0.AfterFunction;
      this.AfterNamespace = $Prm0.AfterNamespace;
      this.AfterObjCDeclaration = $Prm0.AfterObjCDeclaration;
      this.AfterStruct = $Prm0.AfterStruct;
      this.AfterUnion = $Prm0.AfterUnion;
      this.BeforeCatch = $Prm0.BeforeCatch;
      this.BeforeElse = $Prm0.BeforeElse;
      this.IndentBraces = $Prm0.IndentBraces;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::BraceWrappingFlags::BraceWrappingFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 251,
     FQN="clang::format::FormatStyle::BraceWrappingFlags::BraceWrappingFlags", NM="_ZN5clang6format11FormatStyle18BraceWrappingFlagsC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle18BraceWrappingFlagsC1Ev")
    //</editor-fold>
    public /*inline*/ BraceWrappingFlags() {
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public BraceWrappingFlags(boolean AfterClass, boolean AfterControlStatement, boolean AfterEnum, boolean AfterFunction, boolean AfterNamespace, boolean AfterObjCDeclaration, boolean AfterStruct, boolean AfterUnion, boolean BeforeCatch, boolean BeforeElse, boolean IndentBraces) {
      this.AfterClass = AfterClass;
      this.AfterControlStatement = AfterControlStatement;
      this.AfterEnum = AfterEnum;
      this.AfterFunction = AfterFunction;
      this.AfterNamespace = AfterNamespace;
      this.AfterObjCDeclaration = AfterObjCDeclaration;
      this.AfterStruct = AfterStruct;
      this.AfterUnion = AfterUnion;
      this.BeforeCatch = BeforeCatch;
      this.BeforeElse = BeforeElse;
      this.IndentBraces = IndentBraces;
    }

    public bool$ref AfterClass_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return AfterClass;
      }

      @Override
      public boolean $set(boolean value) {
        AfterClass = value;
        return AfterClass;
      }
    };
    public bool$ref AfterControlStatement_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return AfterControlStatement;
      }

      @Override
      public boolean $set(boolean value) {
        AfterControlStatement = value;
        return AfterControlStatement;
      }
    };
    public bool$ref AfterEnum_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return AfterEnum;
      }

      @Override
      public boolean $set(boolean value) {
        AfterEnum = value;
        return AfterEnum;
      }
    };
    public bool$ref AfterFunction_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return AfterFunction;
      }

      @Override
      public boolean $set(boolean value) {
        AfterFunction = value;
        return AfterFunction;
      }
    };
    public bool$ref AfterNamespace_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return AfterNamespace;
      }

      @Override
      public boolean $set(boolean value) {
        AfterNamespace = value;
        return AfterNamespace;
      }
    };
    public bool$ref AfterObjCDeclaration_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return AfterObjCDeclaration;
      }

      @Override
      public boolean $set(boolean value) {
        AfterObjCDeclaration = value;
        return AfterObjCDeclaration;
      }
    };
    public bool$ref AfterStruct_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return AfterStruct;
      }

      @Override
      public boolean $set(boolean value) {
        AfterStruct = value;
        return AfterStruct;
      }
    };
    public bool$ref AfterUnion_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return AfterUnion;
      }

      @Override
      public boolean $set(boolean value) {
        AfterUnion = value;
        return AfterUnion;
      }
    };
    public bool$ref BeforeCatch_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return BeforeCatch;
      }

      @Override
      public boolean $set(boolean value) {
        BeforeCatch = value;
        return BeforeCatch;
      }
    };
    public bool$ref BeforeElse_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return BeforeElse;
      }

      @Override
      public boolean $set(boolean value) {
        BeforeElse = value;
        return BeforeElse;
      }
    };
    public bool$ref IndentBraces_ref = new bool$ref(){
      @Override
      public boolean $deref() {
        return IndentBraces;
      }

      @Override
      public boolean $set(boolean value) {
        IndentBraces = value;
        return IndentBraces;
      }
    };

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "AfterClass=" + AfterClass // NOI18N
                + ", AfterControlStatement=" + AfterControlStatement // NOI18N
                + ", AfterEnum=" + AfterEnum // NOI18N
                + ", AfterFunction=" + AfterFunction // NOI18N
                + ", AfterNamespace=" + AfterNamespace // NOI18N
                + ", AfterObjCDeclaration=" + AfterObjCDeclaration // NOI18N
                + ", AfterStruct=" + AfterStruct // NOI18N
                + ", AfterUnion=" + AfterUnion // NOI18N
                + ", BeforeCatch=" + BeforeCatch // NOI18N
                + ", BeforeElse=" + BeforeElse // NOI18N
                + ", IndentBraces=" + IndentBraces; // NOI18N
    }
  };
  
  /// \brief Control of individual brace wrapping cases.
  ///
  /// If ``BreakBeforeBraces`` is set to ``BS_Custom``, use this to specify how
  /// each individual brace case should be handled. Otherwise, this is ignored.
  public BraceWrappingFlags BraceWrapping;
  
  /// \brief If ``true``, ternary operators will be placed after line breaks.
  public boolean BreakBeforeTernaryOperators;
  
  /// \brief Always break constructor initializers before commas and align
  /// the commas with the colon.
  public boolean BreakConstructorInitializersBeforeComma;
  
  /// \brief Break after each annotation on a field in Java files.
  public boolean BreakAfterJavaFieldAnnotations;
  
  /// \brief Allow breaking string literals when formatting.
  public boolean BreakStringLiterals;
  
  /// \brief The column limit.
  ///
  /// A column limit of ``0`` means that there is no column limit. In this case,
  /// clang-format will respect the input's line breaking decisions within
  /// statements unless they contradict other rules.
  public /*uint*/int ColumnLimit;
  
  /// \brief A regular expression that describes comments with special meaning,
  /// which should not be split into lines or otherwise changed.
  public std.string CommentPragmas;
  
  /// \brief If the constructor initializers don't fit on a line, put each
  /// initializer on its own line.
  public boolean ConstructorInitializerAllOnOneLineOrOnePerLine;
  
  /// \brief The number of characters to use for indentation of constructor
  /// initializer lists.
  public /*uint*/int ConstructorInitializerIndentWidth;
  
  /// \brief Indent width for line continuations.
  public /*uint*/int ContinuationIndentWidth;
  
  /// \brief If ``true``, format braced lists as best suited for C++11 braced
  /// lists.
  ///
  /// Important differences:
  /// - No spaces inside the braced list.
  /// - No line break before the closing brace.
  /// - Indentation with the continuation indent, not with the block indent.
  ///
  /// Fundamentally, C++11 braced lists are formatted exactly like function
  /// calls would be formatted in their place. If the braced list follows a name
  /// (e.g. a type or variable name), clang-format formats as if the ``{}`` were
  /// the parentheses of a function call with that name. If there is no name,
  /// a zero-length name is assumed.
  public boolean Cpp11BracedListStyle;
  
  /// \brief If ``true``, analyze the formatted file for the most common
  /// alignment of ``&`` and ``*``. ``PointerAlignment`` is then used only as
  /// fallback.
  public boolean DerivePointerAlignment;
  
  /// \brief Disables formatting completely.
  public boolean DisableFormat;
  
  /// \brief If ``true``, clang-format detects whether function calls and
  /// definitions are formatted with one parameter per line.
  ///
  /// Each call can be bin-packed, one-per-line or inconclusive. If it is
  /// inconclusive, e.g. completely on one line, but a decision needs to be
  /// made, clang-format analyzes whether there are other bin-packed cases in
  /// the input file and act accordingly.
  ///
  /// NOTE: This is an experimental flag, that might go away or be renamed. Do
  /// not use this in config files, etc. Use at your own risk.
  public boolean ExperimentalAutoDetectBinPacking;
  
  /// \brief A vector of macros that should be interpreted as foreach loops
  /// instead of as function calls.
  ///
  /// These are expected to be macros of the form:
  /// \code
  ///   FOREACH(<variable-declaration>, ...)
  ///     <loop-body>
  /// \endcode
  ///
  /// In the .clang-format configuration file, this can be configured like:
  /// \code{.yaml}
  ///   ForEachMacros: ['RANGES_FOR', 'FOREACH']
  /// \endcode
  ///
  /// For example: BOOST_FOREACH.
  public std.vectorString ForEachMacros;
  
  /// \brief See documentation of ``IncludeCategories``.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::IncludeCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 370,
   FQN="clang::format::FormatStyle::IncludeCategory", NM="_ZN5clang6format11FormatStyle15IncludeCategoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle15IncludeCategoryE")
  //</editor-fold>
  public static class/*struct*/ IncludeCategory implements Destructors.ClassWithDestructor, Native.NativeComparable<IncludeCategory>, Native.NativePOD<IncludeCategory> {
    /// \brief The regular expression that this category matches.
    public std.string Regex;
    /// \brief The priority to assign to this category.
    public int Priority;
    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::IncludeCategory::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 375,
     FQN="clang::format::FormatStyle::IncludeCategory::operator==", NM="_ZNK5clang6format11FormatStyle15IncludeCategoryeqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZNK5clang6format11FormatStyle15IncludeCategoryeqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ IncludeCategory /*&*/ Other) /*const*/ {
      return $eq_str$C(Regex, Other.Regex) && Priority == Other.Priority;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::IncludeCategory::IncludeCategory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 370,
     FQN="clang::format::FormatStyle::IncludeCategory::IncludeCategory", NM="_ZN5clang6format11FormatStyle15IncludeCategoryC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle15IncludeCategoryC1ERKS2_")
    //</editor-fold>
    public /*inline*/ IncludeCategory(final /*const*/ IncludeCategory /*&*/ $Prm0) {
      // : Regex(.Regex), Priority(.Priority) 
      //START JInit
      this.Regex = new std.string($Prm0.Regex);
      this.Priority = $Prm0.Priority;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::IncludeCategory::IncludeCategory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 370,
     FQN="clang::format::FormatStyle::IncludeCategory::IncludeCategory", NM="_ZN5clang6format11FormatStyle15IncludeCategoryC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle15IncludeCategoryC1EOS2_")
    //</editor-fold>
    public /*inline*/ IncludeCategory(JD$Move _dparam, final IncludeCategory /*&&*/$Prm0) {
      // : Regex(static_cast<IncludeCategory &&>().Regex), Priority(static_cast<IncludeCategory &&>().Priority) 
      //START JInit
      this.Regex = new std.string(JD$Move.INSTANCE, $Prm0.Regex);
      this.Priority = $Prm0.Priority;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::IncludeCategory::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 370,
     FQN="clang::format::FormatStyle::IncludeCategory::operator=", NM="_ZN5clang6format11FormatStyle15IncludeCategoryaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle15IncludeCategoryaSERKS2_")
    //</editor-fold>
    public /*inline*/ IncludeCategory /*&*/ $assign(final /*const*/ IncludeCategory /*&*/ $Prm0) {
      this.Regex.$assign($Prm0.Regex);
      this.Priority = $Prm0.Priority;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::IncludeCategory::~IncludeCategory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 370,
     FQN="clang::format::FormatStyle::IncludeCategory::~IncludeCategory", NM="_ZN5clang6format11FormatStyle15IncludeCategoryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle15IncludeCategoryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Regex.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::IncludeCategory::IncludeCategory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 370,
     FQN="clang::format::FormatStyle::IncludeCategory::IncludeCategory", NM="_ZN5clang6format11FormatStyle15IncludeCategoryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle15IncludeCategoryC1Ev")
    //</editor-fold>
    public /*inline*/ IncludeCategory() {
      // : Regex() 
      //START JInit
      this.Regex = new std.string();
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public IncludeCategory(string Regex, int Priority) {
      this.Regex = Regex;
      this.Priority = Priority;
    }

    public IncludeCategory(char$ptr Regex, int Priority) {
      this.Regex = new std.string(Regex);
      this.Priority = Priority;
    }

    @Override
    public IncludeCategory clone() {
      return new IncludeCategory(this);
    }

    public int$ref Priority_ref = new int$ref(){
      @Override
      public int $deref() {
        return Priority;
      }

      @Override
      public int $set(int value) {
        Priority = value;
        return Priority;
      }     
    };

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Regex=" + Regex // NOI18N
                + ", Priority=" + Priority; // NOI18N
    }
  };
  
  /// \brief Regular expressions denoting the different ``#include`` categories
  /// used for ordering ``#includes``.
  ///
  /// These regular expressions are matched against the filename of an include
  /// (including the <> or "") in order. The value belonging to the first
  /// matching regular expression is assigned and ``#includes`` are sorted first
  /// according to increasing category number and then alphabetically within
  /// each category.
  ///
  /// If none of the regular expressions match, INT_MAX is assigned as
  /// category. The main header for a source file automatically gets category 0.
  /// so that it is generally kept at the beginning of the ``#includes``
  /// (http://llvm.org/docs/CodingStandards.html#include-style). However, you
  /// can also assign negative priorities if you have certain headers that
  /// always need to be first.
  ///
  /// To configure this in the .clang-format file, use:
  /// \code{.yaml}
  ///   IncludeCategories:
  ///     - Regex:           '^"(llvm|llvm-c|clang|clang-c)/'
  ///       Priority:        2
  ///     - Regex:           '^(<|"(gtest|isl|json)/)'
  ///       Priority:        3
  ///     - Regex:           '.*'
  ///       Priority:        1
  /// \endcode
  public std.vector<IncludeCategory> IncludeCategories;
  
  /// \brief Specify a regular expression of suffixes that are allowed in the
  /// file-to-main-include mapping.
  ///
  /// When guessing whether a #include is the "main" include (to assign
  /// category 0, see above), use this regex of allowed suffixes to the header
  /// stem. A partial match is done, so that:
  /// - "" means "arbitrary suffix"
  /// - "$" means "no suffix"
  ///
  /// For example, if configured to "(_test)?$", then a header a.h would be seen
  /// as the "main" include in both a.cc and a_test.cc.
  public std.string IncludeIsMainRegex;
  
  /// \brief Indent case labels one level from the switch statement.
  ///
  /// When ``false``, use the same indentation level as for the switch statement.
  /// Switch statement body is always indented one level more than case labels.
  public boolean IndentCaseLabels;
  
  /// \brief The number of columns to use for indentation.
  public /*uint*/int IndentWidth;
  
  /// \brief Indent if a function definition or declaration is wrapped after the
  /// type.
  public boolean IndentWrappedFunctionNames;
  
  /// \brief Quotation styles for JavaScript strings. Does not affect template
  /// strings.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::JavaScriptQuoteStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 436,
   FQN="clang::format::FormatStyle::JavaScriptQuoteStyle", NM="_ZN5clang6format11FormatStyle20JavaScriptQuoteStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle20JavaScriptQuoteStyleE")
  //</editor-fold>
  public enum JavaScriptQuoteStyle implements Native.NativeUIntEnum {
    /// Leave string quotes as they are.
    JSQS_Leave(0),
    /// Always use single quotes.
    JSQS_Single(JSQS_Leave.getValue() + 1),
    /// Always use double quotes.
    JSQS_Double(JSQS_Single.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static JavaScriptQuoteStyle valueOf(int val) {
      JavaScriptQuoteStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final JavaScriptQuoteStyle[] VALUES;
      private static final JavaScriptQuoteStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (JavaScriptQuoteStyle kind : JavaScriptQuoteStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new JavaScriptQuoteStyle[min < 0 ? (1-min) : 0];
        VALUES = new JavaScriptQuoteStyle[max >= 0 ? (1+max) : 0];
        for (JavaScriptQuoteStyle kind : JavaScriptQuoteStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private JavaScriptQuoteStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief The JavaScriptQuoteStyle to use for JavaScript strings.
  public JavaScriptQuoteStyle JavaScriptQuotes = JavaScriptQuoteStyle.JSQS_Leave;
  
  /// \brief Whether to wrap JavaScript import/export statements.
  public boolean JavaScriptWrapImports;
  
  /// \brief If true, empty lines at the start of blocks are kept.
  public boolean KeepEmptyLinesAtTheStartOfBlocks;
  
  /// \brief Supported languages.
  ///
  /// When stored in a configuration file, specifies the language, that the
  /// configuration targets. When passed to the ``reformat()`` function, enables
  /// syntax features specific to the language.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::LanguageKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 459,
   FQN="clang::format::FormatStyle::LanguageKind", NM="_ZN5clang6format11FormatStyle12LanguageKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle12LanguageKindE")
  //</editor-fold>
  public enum LanguageKind implements Native.NativeUIntEnum {
    /// Do not use.
    LK_None(0),
    /// Should be used for C, C++, ObjectiveC, ObjectiveC++.
    LK_Cpp(LK_None.getValue() + 1),
    /// Should be used for Java.
    LK_Java(LK_Cpp.getValue() + 1),
    /// Should be used for JavaScript.
    LK_JavaScript(LK_Java.getValue() + 1),
    /// Should be used for Protocol Buffers
    /// (https://developers.google.com/protocol-buffers/).
    LK_Proto(LK_JavaScript.getValue() + 1),
    /// Should be used for TableGen code.
    LK_TableGen(LK_Proto.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LanguageKind valueOf(int val) {
      LanguageKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LanguageKind[] VALUES;
      private static final LanguageKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LanguageKind kind : LanguageKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LanguageKind[min < 0 ? (1-min) : 0];
        VALUES = new LanguageKind[max >= 0 ? (1+max) : 0];
        for (LanguageKind kind : LanguageKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private LanguageKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Language, this format style is targeted at.
  public LanguageKind Language = LanguageKind.LK_None;
  
  /// \brief A regular expression matching macros that start a block.
  public std.string MacroBlockBegin;
  
  /// \brief A regular expression matching macros that end a block.
  public std.string MacroBlockEnd;
  
  /// \brief The maximum number of consecutive empty lines to keep.
  public /*uint*/int MaxEmptyLinesToKeep;
  
  /// \brief Different ways to indent namespace contents.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::NamespaceIndentationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 488,
   FQN="clang::format::FormatStyle::NamespaceIndentationKind", NM="_ZN5clang6format11FormatStyle24NamespaceIndentationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle24NamespaceIndentationKindE")
  //</editor-fold>
  public enum NamespaceIndentationKind implements Native.NativeUIntEnum {
    /// Don't indent in namespaces.
    NI_None(0),
    /// Indent only in inner namespaces (nested in other namespaces).
    NI_Inner(NI_None.getValue() + 1),
    /// Indent in all namespaces.
    NI_All(NI_Inner.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NamespaceIndentationKind valueOf(int val) {
      NamespaceIndentationKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NamespaceIndentationKind[] VALUES;
      private static final NamespaceIndentationKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NamespaceIndentationKind kind : NamespaceIndentationKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NamespaceIndentationKind[min < 0 ? (1-min) : 0];
        VALUES = new NamespaceIndentationKind[max >= 0 ? (1+max) : 0];
        for (NamespaceIndentationKind kind : NamespaceIndentationKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private NamespaceIndentationKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief The indentation used for namespaces.
  public NamespaceIndentationKind NamespaceIndentation = NamespaceIndentationKind.NI_None;
  
  /// \brief The number of characters to use for indentation of ObjC blocks.
  public /*uint*/int ObjCBlockIndentWidth;
  
  /// \brief Add a space after ``@property`` in Objective-C, i.e. use
  /// ``@property (readonly)`` instead of ``@property(readonly)``.
  public boolean ObjCSpaceAfterProperty;
  
  /// \brief Add a space in front of an Objective-C protocol list, i.e. use
  /// ``Foo <Protocol>`` instead of ``Foo<Protocol>``.
  public boolean ObjCSpaceBeforeProtocolList;
  
  /// \brief The penalty for breaking a function call after ``call(``.
  public /*uint*/int PenaltyBreakBeforeFirstCallParameter;
  
  /// \brief The penalty for each line break introduced inside a comment.
  public /*uint*/int PenaltyBreakComment;
  
  /// \brief The penalty for breaking before the first ``<<``.
  public /*uint*/int PenaltyBreakFirstLessLess;
  
  /// \brief The penalty for each line break introduced inside a string literal.
  public /*uint*/int PenaltyBreakString;
  
  /// \brief The penalty for each character outside of the column limit.
  public /*uint*/int PenaltyExcessCharacter;
  
  /// \brief Penalty for putting the return type of a function onto its own
  /// line.
  public /*uint*/int PenaltyReturnTypeOnItsOwnLine;
  
  /// \brief The ``&`` and ``*`` alignment style.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::PointerAlignmentStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 531,
   FQN="clang::format::FormatStyle::PointerAlignmentStyle", NM="_ZN5clang6format11FormatStyle21PointerAlignmentStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle21PointerAlignmentStyleE")
  //</editor-fold>
  public enum PointerAlignmentStyle implements Native.NativeUIntEnum {
    /// Align pointer to the left.
    PAS_Left(0),
    /// Align pointer to the right.
    PAS_Right(PAS_Left.getValue() + 1),
    /// Align pointer in the middle.
    PAS_Middle(PAS_Right.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PointerAlignmentStyle valueOf(int val) {
      PointerAlignmentStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PointerAlignmentStyle[] VALUES;
      private static final PointerAlignmentStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PointerAlignmentStyle kind : PointerAlignmentStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PointerAlignmentStyle[min < 0 ? (1-min) : 0];
        VALUES = new PointerAlignmentStyle[max >= 0 ? (1+max) : 0];
        for (PointerAlignmentStyle kind : PointerAlignmentStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private PointerAlignmentStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Pointer and reference alignment style.
  public PointerAlignmentStyle PointerAlignment = PointerAlignmentStyle.PAS_Left;
  
  /// \brief If ``true``, clang-format will attempt to re-flow comments.
  public boolean ReflowComments;
  
  /// \brief If ``true``, clang-format will sort ``#includes``.
  public boolean SortIncludes;
  
  /// \brief If ``true``, a space may be inserted after C style casts.
  public boolean SpaceAfterCStyleCast;
  
  /// \brief If ``false``, spaces will be removed before assignment operators.
  public boolean SpaceBeforeAssignmentOperators;
  
  /// \brief Different ways to put a space before opening parentheses.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::SpaceBeforeParensOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 556,
   FQN="clang::format::FormatStyle::SpaceBeforeParensOptions", NM="_ZN5clang6format11FormatStyle24SpaceBeforeParensOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle24SpaceBeforeParensOptionsE")
  //</editor-fold>
  public enum SpaceBeforeParensOptions implements Native.NativeUIntEnum {
    /// Never put a space before opening parentheses.
    SBPO_Never(0),
    /// Put a space before opening parentheses only after control statement
    /// keywords (``for/if/while...``).
    SBPO_ControlStatements(SBPO_Never.getValue() + 1),
    /// Always put a space before opening parentheses, except when it's
    /// prohibited by the syntax rules (in function-like macro definitions) or
    /// when determined by other style rules (after unary operators, opening
    /// parentheses, etc.)
    SBPO_Always(SBPO_ControlStatements.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SpaceBeforeParensOptions valueOf(int val) {
      SpaceBeforeParensOptions out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SpaceBeforeParensOptions[] VALUES;
      private static final SpaceBeforeParensOptions[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SpaceBeforeParensOptions kind : SpaceBeforeParensOptions.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SpaceBeforeParensOptions[min < 0 ? (1-min) : 0];
        VALUES = new SpaceBeforeParensOptions[max >= 0 ? (1+max) : 0];
        for (SpaceBeforeParensOptions kind : SpaceBeforeParensOptions.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private SpaceBeforeParensOptions(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Defines in which cases to put a space before opening parentheses.
  public SpaceBeforeParensOptions SpaceBeforeParens = SpaceBeforeParensOptions.SBPO_Never;
  
  /// \brief If ``true``, spaces may be inserted into ``()``.
  public boolean SpaceInEmptyParentheses;
  
  /// \brief The number of spaces before trailing line comments
  /// (``//`` - comments).
  ///
  /// This does not affect trailing block comments (``/*`` - comments) as
  /// those commonly have different usage patterns and a number of special
  /// cases.
  public /*uint*/int SpacesBeforeTrailingComments;
  
  /// \brief If ``true``, spaces will be inserted after ``<`` and before ``>``
  /// in template argument lists.
  public boolean SpacesInAngles;
  
  /// \brief If ``true``, spaces are inserted inside container literals (e.g.
  /// ObjC and Javascript array and dict literals).
  public boolean SpacesInContainerLiterals;
  
  /// \brief If ``true``, spaces may be inserted into C style casts.
  public boolean SpacesInCStyleCastParentheses;
  
  /// \brief If ``true``, spaces will be inserted after ``(`` and before ``)``.
  public boolean SpacesInParentheses;
  
  /// \brief If ``true``, spaces will be inserted after ``[`` and before ``]``.
  public boolean SpacesInSquareBrackets;
  
  /// \brief Supported language standards.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::LanguageStandard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 601,
   FQN="clang::format::FormatStyle::LanguageStandard", NM="_ZN5clang6format11FormatStyle16LanguageStandardE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle16LanguageStandardE")
  //</editor-fold>
  public enum LanguageStandard implements Native.NativeUIntEnum {
    /// Use C++03-compatible syntax.
    LS_Cpp03(0),
    /// Use features of C++11 (e.g. ``A<A<int>>`` instead of ``A<A<int> >``).
    LS_Cpp11(LS_Cpp03.getValue() + 1),
    /// Automatic detection based on the input.
    LS_Auto(LS_Cpp11.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LanguageStandard valueOf(int val) {
      LanguageStandard out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LanguageStandard[] VALUES;
      private static final LanguageStandard[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LanguageStandard kind : LanguageStandard.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LanguageStandard[min < 0 ? (1-min) : 0];
        VALUES = new LanguageStandard[max >= 0 ? (1+max) : 0];
        for (LanguageStandard kind : LanguageStandard.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private LanguageStandard(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Format compatible with this standard, e.g. use ``A<A<int> >``
  /// instead of ``A<A<int>>`` for ``LS_Cpp03``.
  public LanguageStandard Standard = LanguageStandard.LS_Cpp03;
  
  /// \brief The number of columns used for tab stops.
  public /*uint*/int TabWidth;
  
  /// \brief Different ways to use tab in formatting.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::UseTabStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 618,
   FQN="clang::format::FormatStyle::UseTabStyle", NM="_ZN5clang6format11FormatStyle11UseTabStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyle11UseTabStyleE")
  //</editor-fold>
  public enum UseTabStyle implements Native.NativeUIntEnum {
    /// Never use tab.
    UT_Never(0),
    /// Use tabs only for indentation.
    UT_ForIndentation(UT_Never.getValue() + 1),
    /// Use tabs only for line continuation and indentation.
    UT_ForContinuationAndIndentation(UT_ForIndentation.getValue() + 1),
    /// Use tabs whenever we need to fill whitespace that spans at least from
    /// one tab stop to the next one.
    UT_Always(UT_ForContinuationAndIndentation.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static UseTabStyle valueOf(int val) {
      UseTabStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final UseTabStyle[] VALUES;
      private static final UseTabStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (UseTabStyle kind : UseTabStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new UseTabStyle[min < 0 ? (1-min) : 0];
        VALUES = new UseTabStyle[max >= 0 ? (1+max) : 0];
        for (UseTabStyle kind : UseTabStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private UseTabStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief The way to use tab characters in the resulting file.
  public UseTabStyle UseTab = UseTabStyle.UT_Never;
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 633,
   FQN="clang::format::FormatStyle::operator==", NM="_ZNK5clang6format11FormatStyleeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZNK5clang6format11FormatStyleeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ FormatStyle /*&*/ R) /*const*/ {
    return AccessModifierOffset == R.AccessModifierOffset
       && AlignAfterOpenBracket == R.AlignAfterOpenBracket
       && AlignConsecutiveAssignments == R.AlignConsecutiveAssignments
       && AlignConsecutiveDeclarations == R.AlignConsecutiveDeclarations
       && AlignEscapedNewlinesLeft == R.AlignEscapedNewlinesLeft
       && AlignOperands == R.AlignOperands
       && AlignTrailingComments == R.AlignTrailingComments
       && AllowAllParametersOfDeclarationOnNextLine
       == R.AllowAllParametersOfDeclarationOnNextLine
       && AllowShortBlocksOnASingleLine == R.AllowShortBlocksOnASingleLine
       && AllowShortCaseLabelsOnASingleLine
       == R.AllowShortCaseLabelsOnASingleLine
       && AllowShortFunctionsOnASingleLine
       == R.AllowShortFunctionsOnASingleLine
       && AllowShortIfStatementsOnASingleLine
       == R.AllowShortIfStatementsOnASingleLine
       && AllowShortLoopsOnASingleLine == R.AllowShortLoopsOnASingleLine
       && AlwaysBreakAfterReturnType == R.AlwaysBreakAfterReturnType
       && AlwaysBreakBeforeMultilineStrings
       == R.AlwaysBreakBeforeMultilineStrings
       && AlwaysBreakTemplateDeclarations
       == R.AlwaysBreakTemplateDeclarations
       && BinPackArguments == R.BinPackArguments
       && BinPackParameters == R.BinPackParameters
       && BreakBeforeBinaryOperators == R.BreakBeforeBinaryOperators
       && BreakBeforeBraces == R.BreakBeforeBraces
       && BreakBeforeTernaryOperators == R.BreakBeforeTernaryOperators
       && BreakConstructorInitializersBeforeComma
       == R.BreakConstructorInitializersBeforeComma
       && BreakAfterJavaFieldAnnotations == R.BreakAfterJavaFieldAnnotations
       && BreakStringLiterals == R.BreakStringLiterals
       && ColumnLimit == R.ColumnLimit && $eq_str$C(CommentPragmas, R.CommentPragmas)
       && ConstructorInitializerAllOnOneLineOrOnePerLine
       == R.ConstructorInitializerAllOnOneLineOrOnePerLine
       && ConstructorInitializerIndentWidth
       == R.ConstructorInitializerIndentWidth
       && ContinuationIndentWidth == R.ContinuationIndentWidth
       && Cpp11BracedListStyle == R.Cpp11BracedListStyle
       && DerivePointerAlignment == R.DerivePointerAlignment
       && DisableFormat == R.DisableFormat
       && ExperimentalAutoDetectBinPacking
       == R.ExperimentalAutoDetectBinPacking
       && $eq_vector$_Tp$_Alloc$C(ForEachMacros, R.ForEachMacros)
       && $eq_vector$_Tp$_Alloc$C(IncludeCategories, R.IncludeCategories)
       && IndentCaseLabels == R.IndentCaseLabels
       && IndentWidth == R.IndentWidth && Language == R.Language
       && IndentWrappedFunctionNames == R.IndentWrappedFunctionNames
       && JavaScriptQuotes == R.JavaScriptQuotes
       && JavaScriptWrapImports == R.JavaScriptWrapImports
       && KeepEmptyLinesAtTheStartOfBlocks
       == R.KeepEmptyLinesAtTheStartOfBlocks
       && $eq_str$C(MacroBlockBegin, R.MacroBlockBegin)
       && $eq_str$C(MacroBlockEnd, R.MacroBlockEnd)
       && MaxEmptyLinesToKeep == R.MaxEmptyLinesToKeep
       && NamespaceIndentation == R.NamespaceIndentation
       && ObjCBlockIndentWidth == R.ObjCBlockIndentWidth
       && ObjCSpaceAfterProperty == R.ObjCSpaceAfterProperty
       && ObjCSpaceBeforeProtocolList == R.ObjCSpaceBeforeProtocolList
       && PenaltyBreakBeforeFirstCallParameter
       == R.PenaltyBreakBeforeFirstCallParameter
       && PenaltyBreakComment == R.PenaltyBreakComment
       && PenaltyBreakFirstLessLess == R.PenaltyBreakFirstLessLess
       && PenaltyBreakString == R.PenaltyBreakString
       && PenaltyExcessCharacter == R.PenaltyExcessCharacter
       && PenaltyReturnTypeOnItsOwnLine == R.PenaltyReturnTypeOnItsOwnLine
       && PointerAlignment == R.PointerAlignment
       && SpaceAfterCStyleCast == R.SpaceAfterCStyleCast
       && SpaceBeforeAssignmentOperators == R.SpaceBeforeAssignmentOperators
       && SpaceBeforeParens == R.SpaceBeforeParens
       && SpaceInEmptyParentheses == R.SpaceInEmptyParentheses
       && SpacesBeforeTrailingComments == R.SpacesBeforeTrailingComments
       && SpacesInAngles == R.SpacesInAngles
       && SpacesInContainerLiterals == R.SpacesInContainerLiterals
       && SpacesInCStyleCastParentheses == R.SpacesInCStyleCastParentheses
       && SpacesInParentheses == R.SpacesInParentheses
       && SpacesInSquareBrackets == R.SpacesInSquareBrackets
       && Standard == R.Standard && TabWidth == R.TabWidth
       && UseTab == R.UseTab;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::FormatStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 46,
   FQN="clang::format::FormatStyle::FormatStyle", NM="_ZN5clang6format11FormatStyleC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyleC1ERKS1_")
  //</editor-fold>
  public /*inline*/ FormatStyle(final /*const*/ FormatStyle /*&*/ $Prm0) {
    // : AccessModifierOffset(.AccessModifierOffset), AlignAfterOpenBracket(.AlignAfterOpenBracket), AlignConsecutiveAssignments(.AlignConsecutiveAssignments), AlignConsecutiveDeclarations(.AlignConsecutiveDeclarations), AlignEscapedNewlinesLeft(.AlignEscapedNewlinesLeft), AlignOperands(.AlignOperands), AlignTrailingComments(.AlignTrailingComments), AllowAllParametersOfDeclarationOnNextLine(.AllowAllParametersOfDeclarationOnNextLine), AllowShortBlocksOnASingleLine(.AllowShortBlocksOnASingleLine), AllowShortCaseLabelsOnASingleLine(.AllowShortCaseLabelsOnASingleLine), AllowShortFunctionsOnASingleLine(.AllowShortFunctionsOnASingleLine), AllowShortIfStatementsOnASingleLine(.AllowShortIfStatementsOnASingleLine), AllowShortLoopsOnASingleLine(.AllowShortLoopsOnASingleLine), AlwaysBreakAfterDefinitionReturnType(.AlwaysBreakAfterDefinitionReturnType), AlwaysBreakAfterReturnType(.AlwaysBreakAfterReturnType), AlwaysBreakBeforeMultilineStrings(.AlwaysBreakBeforeMultilineStrings), AlwaysBreakTemplateDeclarations(.AlwaysBreakTemplateDeclarations), BinPackArguments(.BinPackArguments), BinPackParameters(.BinPackParameters), BreakBeforeBinaryOperators(.BreakBeforeBinaryOperators), BreakBeforeBraces(.BreakBeforeBraces), BraceWrapping(.BraceWrapping), BreakBeforeTernaryOperators(.BreakBeforeTernaryOperators), BreakConstructorInitializersBeforeComma(.BreakConstructorInitializersBeforeComma), BreakAfterJavaFieldAnnotations(.BreakAfterJavaFieldAnnotations), BreakStringLiterals(.BreakStringLiterals), ColumnLimit(.ColumnLimit), CommentPragmas(.CommentPragmas), ConstructorInitializerAllOnOneLineOrOnePerLine(.ConstructorInitializerAllOnOneLineOrOnePerLine), ConstructorInitializerIndentWidth(.ConstructorInitializerIndentWidth), ContinuationIndentWidth(.ContinuationIndentWidth), Cpp11BracedListStyle(.Cpp11BracedListStyle), DerivePointerAlignment(.DerivePointerAlignment), DisableFormat(.DisableFormat), ExperimentalAutoDetectBinPacking(.ExperimentalAutoDetectBinPacking), ForEachMacros(.ForEachMacros), IncludeCategories(.IncludeCategories), IncludeIsMainRegex(.IncludeIsMainRegex), IndentCaseLabels(.IndentCaseLabels), IndentWidth(.IndentWidth), IndentWrappedFunctionNames(.IndentWrappedFunctionNames), JavaScriptQuotes(.JavaScriptQuotes), JavaScriptWrapImports(.JavaScriptWrapImports), KeepEmptyLinesAtTheStartOfBlocks(.KeepEmptyLinesAtTheStartOfBlocks), Language(.Language), MacroBlockBegin(.MacroBlockBegin), MacroBlockEnd(.MacroBlockEnd), MaxEmptyLinesToKeep(.MaxEmptyLinesToKeep), NamespaceIndentation(.NamespaceIndentation), ObjCBlockIndentWidth(.ObjCBlockIndentWidth), ObjCSpaceAfterProperty(.ObjCSpaceAfterProperty), ObjCSpaceBeforeProtocolList(.ObjCSpaceBeforeProtocolList), PenaltyBreakBeforeFirstCallParameter(.PenaltyBreakBeforeFirstCallParameter), PenaltyBreakComment(.PenaltyBreakComment), PenaltyBreakFirstLessLess(.PenaltyBreakFirstLessLess), PenaltyBreakString(.PenaltyBreakString), PenaltyExcessCharacter(.PenaltyExcessCharacter), PenaltyReturnTypeOnItsOwnLine(.PenaltyReturnTypeOnItsOwnLine), PointerAlignment(.PointerAlignment), ReflowComments(.ReflowComments), SortIncludes(.SortIncludes), SpaceAfterCStyleCast(.SpaceAfterCStyleCast), SpaceBeforeAssignmentOperators(.SpaceBeforeAssignmentOperators), SpaceBeforeParens(.SpaceBeforeParens), SpaceInEmptyParentheses(.SpaceInEmptyParentheses), SpacesBeforeTrailingComments(.SpacesBeforeTrailingComments), SpacesInAngles(.SpacesInAngles), SpacesInContainerLiterals(.SpacesInContainerLiterals), SpacesInCStyleCastParentheses(.SpacesInCStyleCastParentheses), SpacesInParentheses(.SpacesInParentheses), SpacesInSquareBrackets(.SpacesInSquareBrackets), Standard(.Standard), TabWidth(.TabWidth), UseTab(.UseTab) 
    //START JInit
    this.AccessModifierOffset = $Prm0.AccessModifierOffset;
    this.AlignAfterOpenBracket = $Prm0.AlignAfterOpenBracket;
    this.AlignConsecutiveAssignments = $Prm0.AlignConsecutiveAssignments;
    this.AlignConsecutiveDeclarations = $Prm0.AlignConsecutiveDeclarations;
    this.AlignEscapedNewlinesLeft = $Prm0.AlignEscapedNewlinesLeft;
    this.AlignOperands = $Prm0.AlignOperands;
    this.AlignTrailingComments = $Prm0.AlignTrailingComments;
    this.AllowAllParametersOfDeclarationOnNextLine = $Prm0.AllowAllParametersOfDeclarationOnNextLine;
    this.AllowShortBlocksOnASingleLine = $Prm0.AllowShortBlocksOnASingleLine;
    this.AllowShortCaseLabelsOnASingleLine = $Prm0.AllowShortCaseLabelsOnASingleLine;
    this.AllowShortFunctionsOnASingleLine = $Prm0.AllowShortFunctionsOnASingleLine;
    this.AllowShortIfStatementsOnASingleLine = $Prm0.AllowShortIfStatementsOnASingleLine;
    this.AllowShortLoopsOnASingleLine = $Prm0.AllowShortLoopsOnASingleLine;
    this.AlwaysBreakAfterDefinitionReturnType = $Prm0.AlwaysBreakAfterDefinitionReturnType;
    this.AlwaysBreakAfterReturnType = $Prm0.AlwaysBreakAfterReturnType;
    this.AlwaysBreakBeforeMultilineStrings = $Prm0.AlwaysBreakBeforeMultilineStrings;
    this.AlwaysBreakTemplateDeclarations = $Prm0.AlwaysBreakTemplateDeclarations;
    this.BinPackArguments = $Prm0.BinPackArguments;
    this.BinPackParameters = $Prm0.BinPackParameters;
    this.BreakBeforeBinaryOperators = $Prm0.BreakBeforeBinaryOperators;
    this.BreakBeforeBraces = $Prm0.BreakBeforeBraces;
    this.BraceWrapping = new BraceWrappingFlags($Prm0.BraceWrapping);
    this.BreakBeforeTernaryOperators = $Prm0.BreakBeforeTernaryOperators;
    this.BreakConstructorInitializersBeforeComma = $Prm0.BreakConstructorInitializersBeforeComma;
    this.BreakAfterJavaFieldAnnotations = $Prm0.BreakAfterJavaFieldAnnotations;
    this.BreakStringLiterals = $Prm0.BreakStringLiterals;
    this.ColumnLimit = $Prm0.ColumnLimit;
    this.CommentPragmas = new std.string($Prm0.CommentPragmas);
    this.ConstructorInitializerAllOnOneLineOrOnePerLine = $Prm0.ConstructorInitializerAllOnOneLineOrOnePerLine;
    this.ConstructorInitializerIndentWidth = $Prm0.ConstructorInitializerIndentWidth;
    this.ContinuationIndentWidth = $Prm0.ContinuationIndentWidth;
    this.Cpp11BracedListStyle = $Prm0.Cpp11BracedListStyle;
    this.DerivePointerAlignment = $Prm0.DerivePointerAlignment;
    this.DisableFormat = $Prm0.DisableFormat;
    this.ExperimentalAutoDetectBinPacking = $Prm0.ExperimentalAutoDetectBinPacking;
    this.ForEachMacros = new std.vectorString($Prm0.ForEachMacros);
    this.IncludeCategories = new std.vector<IncludeCategory>($Prm0.IncludeCategories);
    this.IncludeIsMainRegex = new std.string($Prm0.IncludeIsMainRegex);
    this.IndentCaseLabels = $Prm0.IndentCaseLabels;
    this.IndentWidth = $Prm0.IndentWidth;
    this.IndentWrappedFunctionNames = $Prm0.IndentWrappedFunctionNames;
    this.JavaScriptQuotes = $Prm0.JavaScriptQuotes;
    this.JavaScriptWrapImports = $Prm0.JavaScriptWrapImports;
    this.KeepEmptyLinesAtTheStartOfBlocks = $Prm0.KeepEmptyLinesAtTheStartOfBlocks;
    this.Language = $Prm0.Language;
    this.MacroBlockBegin = new std.string($Prm0.MacroBlockBegin);
    this.MacroBlockEnd = new std.string($Prm0.MacroBlockEnd);
    this.MaxEmptyLinesToKeep = $Prm0.MaxEmptyLinesToKeep;
    this.NamespaceIndentation = $Prm0.NamespaceIndentation;
    this.ObjCBlockIndentWidth = $Prm0.ObjCBlockIndentWidth;
    this.ObjCSpaceAfterProperty = $Prm0.ObjCSpaceAfterProperty;
    this.ObjCSpaceBeforeProtocolList = $Prm0.ObjCSpaceBeforeProtocolList;
    this.PenaltyBreakBeforeFirstCallParameter = $Prm0.PenaltyBreakBeforeFirstCallParameter;
    this.PenaltyBreakComment = $Prm0.PenaltyBreakComment;
    this.PenaltyBreakFirstLessLess = $Prm0.PenaltyBreakFirstLessLess;
    this.PenaltyBreakString = $Prm0.PenaltyBreakString;
    this.PenaltyExcessCharacter = $Prm0.PenaltyExcessCharacter;
    this.PenaltyReturnTypeOnItsOwnLine = $Prm0.PenaltyReturnTypeOnItsOwnLine;
    this.PointerAlignment = $Prm0.PointerAlignment;
    this.ReflowComments = $Prm0.ReflowComments;
    this.SortIncludes = $Prm0.SortIncludes;
    this.SpaceAfterCStyleCast = $Prm0.SpaceAfterCStyleCast;
    this.SpaceBeforeAssignmentOperators = $Prm0.SpaceBeforeAssignmentOperators;
    this.SpaceBeforeParens = $Prm0.SpaceBeforeParens;
    this.SpaceInEmptyParentheses = $Prm0.SpaceInEmptyParentheses;
    this.SpacesBeforeTrailingComments = $Prm0.SpacesBeforeTrailingComments;
    this.SpacesInAngles = $Prm0.SpacesInAngles;
    this.SpacesInContainerLiterals = $Prm0.SpacesInContainerLiterals;
    this.SpacesInCStyleCastParentheses = $Prm0.SpacesInCStyleCastParentheses;
    this.SpacesInParentheses = $Prm0.SpacesInParentheses;
    this.SpacesInSquareBrackets = $Prm0.SpacesInSquareBrackets;
    this.Standard = $Prm0.Standard;
    this.TabWidth = $Prm0.TabWidth;
    this.UseTab = $Prm0.UseTab;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::FormatStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 46,
   FQN="clang::format::FormatStyle::FormatStyle", NM="_ZN5clang6format11FormatStyleC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyleC1EOS1_")
  //</editor-fold>
  public /*inline*/ FormatStyle(JD$Move _dparam, final FormatStyle /*&&*/$Prm0) {
    // : AccessModifierOffset(static_cast<FormatStyle &&>().AccessModifierOffset), AlignAfterOpenBracket(static_cast<FormatStyle &&>().AlignAfterOpenBracket), AlignConsecutiveAssignments(static_cast<FormatStyle &&>().AlignConsecutiveAssignments), AlignConsecutiveDeclarations(static_cast<FormatStyle &&>().AlignConsecutiveDeclarations), AlignEscapedNewlinesLeft(static_cast<FormatStyle &&>().AlignEscapedNewlinesLeft), AlignOperands(static_cast<FormatStyle &&>().AlignOperands), AlignTrailingComments(static_cast<FormatStyle &&>().AlignTrailingComments), AllowAllParametersOfDeclarationOnNextLine(static_cast<FormatStyle &&>().AllowAllParametersOfDeclarationOnNextLine), AllowShortBlocksOnASingleLine(static_cast<FormatStyle &&>().AllowShortBlocksOnASingleLine), AllowShortCaseLabelsOnASingleLine(static_cast<FormatStyle &&>().AllowShortCaseLabelsOnASingleLine), AllowShortFunctionsOnASingleLine(static_cast<FormatStyle &&>().AllowShortFunctionsOnASingleLine), AllowShortIfStatementsOnASingleLine(static_cast<FormatStyle &&>().AllowShortIfStatementsOnASingleLine), AllowShortLoopsOnASingleLine(static_cast<FormatStyle &&>().AllowShortLoopsOnASingleLine), AlwaysBreakAfterDefinitionReturnType(static_cast<FormatStyle &&>().AlwaysBreakAfterDefinitionReturnType), AlwaysBreakAfterReturnType(static_cast<FormatStyle &&>().AlwaysBreakAfterReturnType), AlwaysBreakBeforeMultilineStrings(static_cast<FormatStyle &&>().AlwaysBreakBeforeMultilineStrings), AlwaysBreakTemplateDeclarations(static_cast<FormatStyle &&>().AlwaysBreakTemplateDeclarations), BinPackArguments(static_cast<FormatStyle &&>().BinPackArguments), BinPackParameters(static_cast<FormatStyle &&>().BinPackParameters), BreakBeforeBinaryOperators(static_cast<FormatStyle &&>().BreakBeforeBinaryOperators), BreakBeforeBraces(static_cast<FormatStyle &&>().BreakBeforeBraces), BraceWrapping(static_cast<FormatStyle &&>().BraceWrapping), BreakBeforeTernaryOperators(static_cast<FormatStyle &&>().BreakBeforeTernaryOperators), BreakConstructorInitializersBeforeComma(static_cast<FormatStyle &&>().BreakConstructorInitializersBeforeComma), BreakAfterJavaFieldAnnotations(static_cast<FormatStyle &&>().BreakAfterJavaFieldAnnotations), BreakStringLiterals(static_cast<FormatStyle &&>().BreakStringLiterals), ColumnLimit(static_cast<FormatStyle &&>().ColumnLimit), CommentPragmas(static_cast<FormatStyle &&>().CommentPragmas), ConstructorInitializerAllOnOneLineOrOnePerLine(static_cast<FormatStyle &&>().ConstructorInitializerAllOnOneLineOrOnePerLine), ConstructorInitializerIndentWidth(static_cast<FormatStyle &&>().ConstructorInitializerIndentWidth), ContinuationIndentWidth(static_cast<FormatStyle &&>().ContinuationIndentWidth), Cpp11BracedListStyle(static_cast<FormatStyle &&>().Cpp11BracedListStyle), DerivePointerAlignment(static_cast<FormatStyle &&>().DerivePointerAlignment), DisableFormat(static_cast<FormatStyle &&>().DisableFormat), ExperimentalAutoDetectBinPacking(static_cast<FormatStyle &&>().ExperimentalAutoDetectBinPacking), ForEachMacros(static_cast<FormatStyle &&>().ForEachMacros), IncludeCategories(static_cast<FormatStyle &&>().IncludeCategories), IncludeIsMainRegex(static_cast<FormatStyle &&>().IncludeIsMainRegex), IndentCaseLabels(static_cast<FormatStyle &&>().IndentCaseLabels), IndentWidth(static_cast<FormatStyle &&>().IndentWidth), IndentWrappedFunctionNames(static_cast<FormatStyle &&>().IndentWrappedFunctionNames), JavaScriptQuotes(static_cast<FormatStyle &&>().JavaScriptQuotes), JavaScriptWrapImports(static_cast<FormatStyle &&>().JavaScriptWrapImports), KeepEmptyLinesAtTheStartOfBlocks(static_cast<FormatStyle &&>().KeepEmptyLinesAtTheStartOfBlocks), Language(static_cast<FormatStyle &&>().Language), MacroBlockBegin(static_cast<FormatStyle &&>().MacroBlockBegin), MacroBlockEnd(static_cast<FormatStyle &&>().MacroBlockEnd), MaxEmptyLinesToKeep(static_cast<FormatStyle &&>().MaxEmptyLinesToKeep), NamespaceIndentation(static_cast<FormatStyle &&>().NamespaceIndentation), ObjCBlockIndentWidth(static_cast<FormatStyle &&>().ObjCBlockIndentWidth), ObjCSpaceAfterProperty(static_cast<FormatStyle &&>().ObjCSpaceAfterProperty), ObjCSpaceBeforeProtocolList(static_cast<FormatStyle &&>().ObjCSpaceBeforeProtocolList), PenaltyBreakBeforeFirstCallParameter(static_cast<FormatStyle &&>().PenaltyBreakBeforeFirstCallParameter), PenaltyBreakComment(static_cast<FormatStyle &&>().PenaltyBreakComment), PenaltyBreakFirstLessLess(static_cast<FormatStyle &&>().PenaltyBreakFirstLessLess), PenaltyBreakString(static_cast<FormatStyle &&>().PenaltyBreakString), PenaltyExcessCharacter(static_cast<FormatStyle &&>().PenaltyExcessCharacter), PenaltyReturnTypeOnItsOwnLine(static_cast<FormatStyle &&>().PenaltyReturnTypeOnItsOwnLine), PointerAlignment(static_cast<FormatStyle &&>().PointerAlignment), ReflowComments(static_cast<FormatStyle &&>().ReflowComments), SortIncludes(static_cast<FormatStyle &&>().SortIncludes), SpaceAfterCStyleCast(static_cast<FormatStyle &&>().SpaceAfterCStyleCast), SpaceBeforeAssignmentOperators(static_cast<FormatStyle &&>().SpaceBeforeAssignmentOperators), SpaceBeforeParens(static_cast<FormatStyle &&>().SpaceBeforeParens), SpaceInEmptyParentheses(static_cast<FormatStyle &&>().SpaceInEmptyParentheses), SpacesBeforeTrailingComments(static_cast<FormatStyle &&>().SpacesBeforeTrailingComments), SpacesInAngles(static_cast<FormatStyle &&>().SpacesInAngles), SpacesInContainerLiterals(static_cast<FormatStyle &&>().SpacesInContainerLiterals), SpacesInCStyleCastParentheses(static_cast<FormatStyle &&>().SpacesInCStyleCastParentheses), SpacesInParentheses(static_cast<FormatStyle &&>().SpacesInParentheses), SpacesInSquareBrackets(static_cast<FormatStyle &&>().SpacesInSquareBrackets), Standard(static_cast<FormatStyle &&>().Standard), TabWidth(static_cast<FormatStyle &&>().TabWidth), UseTab(static_cast<FormatStyle &&>().UseTab) 
    //START JInit
    this.AccessModifierOffset = $Prm0.AccessModifierOffset;
    this.AlignAfterOpenBracket = $Prm0.AlignAfterOpenBracket;
    this.AlignConsecutiveAssignments = $Prm0.AlignConsecutiveAssignments;
    this.AlignConsecutiveDeclarations = $Prm0.AlignConsecutiveDeclarations;
    this.AlignEscapedNewlinesLeft = $Prm0.AlignEscapedNewlinesLeft;
    this.AlignOperands = $Prm0.AlignOperands;
    this.AlignTrailingComments = $Prm0.AlignTrailingComments;
    this.AllowAllParametersOfDeclarationOnNextLine = $Prm0.AllowAllParametersOfDeclarationOnNextLine;
    this.AllowShortBlocksOnASingleLine = $Prm0.AllowShortBlocksOnASingleLine;
    this.AllowShortCaseLabelsOnASingleLine = $Prm0.AllowShortCaseLabelsOnASingleLine;
    this.AllowShortFunctionsOnASingleLine = $Prm0.AllowShortFunctionsOnASingleLine;
    this.AllowShortIfStatementsOnASingleLine = $Prm0.AllowShortIfStatementsOnASingleLine;
    this.AllowShortLoopsOnASingleLine = $Prm0.AllowShortLoopsOnASingleLine;
    this.AlwaysBreakAfterDefinitionReturnType = $Prm0.AlwaysBreakAfterDefinitionReturnType;
    this.AlwaysBreakAfterReturnType = $Prm0.AlwaysBreakAfterReturnType;
    this.AlwaysBreakBeforeMultilineStrings = $Prm0.AlwaysBreakBeforeMultilineStrings;
    this.AlwaysBreakTemplateDeclarations = $Prm0.AlwaysBreakTemplateDeclarations;
    this.BinPackArguments = $Prm0.BinPackArguments;
    this.BinPackParameters = $Prm0.BinPackParameters;
    this.BreakBeforeBinaryOperators = $Prm0.BreakBeforeBinaryOperators;
    this.BreakBeforeBraces = $Prm0.BreakBeforeBraces;
    this.BraceWrapping = new BraceWrappingFlags(JD$Move.INSTANCE, $Prm0.BraceWrapping);
    this.BreakBeforeTernaryOperators = $Prm0.BreakBeforeTernaryOperators;
    this.BreakConstructorInitializersBeforeComma = $Prm0.BreakConstructorInitializersBeforeComma;
    this.BreakAfterJavaFieldAnnotations = $Prm0.BreakAfterJavaFieldAnnotations;
    this.BreakStringLiterals = $Prm0.BreakStringLiterals;
    this.ColumnLimit = $Prm0.ColumnLimit;
    this.CommentPragmas = new std.string(JD$Move.INSTANCE, $Prm0.CommentPragmas);
    this.ConstructorInitializerAllOnOneLineOrOnePerLine = $Prm0.ConstructorInitializerAllOnOneLineOrOnePerLine;
    this.ConstructorInitializerIndentWidth = $Prm0.ConstructorInitializerIndentWidth;
    this.ContinuationIndentWidth = $Prm0.ContinuationIndentWidth;
    this.Cpp11BracedListStyle = $Prm0.Cpp11BracedListStyle;
    this.DerivePointerAlignment = $Prm0.DerivePointerAlignment;
    this.DisableFormat = $Prm0.DisableFormat;
    this.ExperimentalAutoDetectBinPacking = $Prm0.ExperimentalAutoDetectBinPacking;
    this.ForEachMacros = new std.vectorString(JD$Move.INSTANCE, $Prm0.ForEachMacros);
    this.IncludeCategories = new std.vector<IncludeCategory>(JD$Move.INSTANCE, $Prm0.IncludeCategories);
    this.IncludeIsMainRegex = new std.string(JD$Move.INSTANCE, $Prm0.IncludeIsMainRegex);
    this.IndentCaseLabels = $Prm0.IndentCaseLabels;
    this.IndentWidth = $Prm0.IndentWidth;
    this.IndentWrappedFunctionNames = $Prm0.IndentWrappedFunctionNames;
    this.JavaScriptQuotes = $Prm0.JavaScriptQuotes;
    this.JavaScriptWrapImports = $Prm0.JavaScriptWrapImports;
    this.KeepEmptyLinesAtTheStartOfBlocks = $Prm0.KeepEmptyLinesAtTheStartOfBlocks;
    this.Language = $Prm0.Language;
    this.MacroBlockBegin = new std.string(JD$Move.INSTANCE, $Prm0.MacroBlockBegin);
    this.MacroBlockEnd = new std.string(JD$Move.INSTANCE, $Prm0.MacroBlockEnd);
    this.MaxEmptyLinesToKeep = $Prm0.MaxEmptyLinesToKeep;
    this.NamespaceIndentation = $Prm0.NamespaceIndentation;
    this.ObjCBlockIndentWidth = $Prm0.ObjCBlockIndentWidth;
    this.ObjCSpaceAfterProperty = $Prm0.ObjCSpaceAfterProperty;
    this.ObjCSpaceBeforeProtocolList = $Prm0.ObjCSpaceBeforeProtocolList;
    this.PenaltyBreakBeforeFirstCallParameter = $Prm0.PenaltyBreakBeforeFirstCallParameter;
    this.PenaltyBreakComment = $Prm0.PenaltyBreakComment;
    this.PenaltyBreakFirstLessLess = $Prm0.PenaltyBreakFirstLessLess;
    this.PenaltyBreakString = $Prm0.PenaltyBreakString;
    this.PenaltyExcessCharacter = $Prm0.PenaltyExcessCharacter;
    this.PenaltyReturnTypeOnItsOwnLine = $Prm0.PenaltyReturnTypeOnItsOwnLine;
    this.PointerAlignment = $Prm0.PointerAlignment;
    this.ReflowComments = $Prm0.ReflowComments;
    this.SortIncludes = $Prm0.SortIncludes;
    this.SpaceAfterCStyleCast = $Prm0.SpaceAfterCStyleCast;
    this.SpaceBeforeAssignmentOperators = $Prm0.SpaceBeforeAssignmentOperators;
    this.SpaceBeforeParens = $Prm0.SpaceBeforeParens;
    this.SpaceInEmptyParentheses = $Prm0.SpaceInEmptyParentheses;
    this.SpacesBeforeTrailingComments = $Prm0.SpacesBeforeTrailingComments;
    this.SpacesInAngles = $Prm0.SpacesInAngles;
    this.SpacesInContainerLiterals = $Prm0.SpacesInContainerLiterals;
    this.SpacesInCStyleCastParentheses = $Prm0.SpacesInCStyleCastParentheses;
    this.SpacesInParentheses = $Prm0.SpacesInParentheses;
    this.SpacesInSquareBrackets = $Prm0.SpacesInSquareBrackets;
    this.Standard = $Prm0.Standard;
    this.TabWidth = $Prm0.TabWidth;
    this.UseTab = $Prm0.UseTab;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 46,
   FQN="clang::format::FormatStyle::operator=", NM="_ZN5clang6format11FormatStyleaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyleaSERKS1_")
  //</editor-fold>
  public /*inline*/ FormatStyle /*&*/ $assign(final /*const*/ FormatStyle /*&*/ $Prm0) {
    this.AccessModifierOffset = $Prm0.AccessModifierOffset;
    this.AlignAfterOpenBracket = $Prm0.AlignAfterOpenBracket;
    this.AlignConsecutiveAssignments = $Prm0.AlignConsecutiveAssignments;
    this.AlignConsecutiveDeclarations = $Prm0.AlignConsecutiveDeclarations;
    this.AlignEscapedNewlinesLeft = $Prm0.AlignEscapedNewlinesLeft;
    this.AlignOperands = $Prm0.AlignOperands;
    this.AlignTrailingComments = $Prm0.AlignTrailingComments;
    this.AllowAllParametersOfDeclarationOnNextLine = $Prm0.AllowAllParametersOfDeclarationOnNextLine;
    this.AllowShortBlocksOnASingleLine = $Prm0.AllowShortBlocksOnASingleLine;
    this.AllowShortCaseLabelsOnASingleLine = $Prm0.AllowShortCaseLabelsOnASingleLine;
    this.AllowShortFunctionsOnASingleLine = $Prm0.AllowShortFunctionsOnASingleLine;
    this.AllowShortIfStatementsOnASingleLine = $Prm0.AllowShortIfStatementsOnASingleLine;
    this.AllowShortLoopsOnASingleLine = $Prm0.AllowShortLoopsOnASingleLine;
    this.AlwaysBreakAfterDefinitionReturnType = $Prm0.AlwaysBreakAfterDefinitionReturnType;
    this.AlwaysBreakAfterReturnType = $Prm0.AlwaysBreakAfterReturnType;
    this.AlwaysBreakBeforeMultilineStrings = $Prm0.AlwaysBreakBeforeMultilineStrings;
    this.AlwaysBreakTemplateDeclarations = $Prm0.AlwaysBreakTemplateDeclarations;
    this.BinPackArguments = $Prm0.BinPackArguments;
    this.BinPackParameters = $Prm0.BinPackParameters;
    this.BreakBeforeBinaryOperators = $Prm0.BreakBeforeBinaryOperators;
    this.BreakBeforeBraces = $Prm0.BreakBeforeBraces;
    this.BraceWrapping.$assign($Prm0.BraceWrapping);
    this.BreakBeforeTernaryOperators = $Prm0.BreakBeforeTernaryOperators;
    this.BreakConstructorInitializersBeforeComma = $Prm0.BreakConstructorInitializersBeforeComma;
    this.BreakAfterJavaFieldAnnotations = $Prm0.BreakAfterJavaFieldAnnotations;
    this.BreakStringLiterals = $Prm0.BreakStringLiterals;
    this.ColumnLimit = $Prm0.ColumnLimit;
    this.CommentPragmas.$assign($Prm0.CommentPragmas);
    this.ConstructorInitializerAllOnOneLineOrOnePerLine = $Prm0.ConstructorInitializerAllOnOneLineOrOnePerLine;
    this.ConstructorInitializerIndentWidth = $Prm0.ConstructorInitializerIndentWidth;
    this.ContinuationIndentWidth = $Prm0.ContinuationIndentWidth;
    this.Cpp11BracedListStyle = $Prm0.Cpp11BracedListStyle;
    this.DerivePointerAlignment = $Prm0.DerivePointerAlignment;
    this.DisableFormat = $Prm0.DisableFormat;
    this.ExperimentalAutoDetectBinPacking = $Prm0.ExperimentalAutoDetectBinPacking;
    this.ForEachMacros.$assign($Prm0.ForEachMacros);
    this.IncludeCategories.$assign($Prm0.IncludeCategories);
    this.IncludeIsMainRegex.$assign($Prm0.IncludeIsMainRegex);
    this.IndentCaseLabels = $Prm0.IndentCaseLabels;
    this.IndentWidth = $Prm0.IndentWidth;
    this.IndentWrappedFunctionNames = $Prm0.IndentWrappedFunctionNames;
    this.JavaScriptQuotes = $Prm0.JavaScriptQuotes;
    this.JavaScriptWrapImports = $Prm0.JavaScriptWrapImports;
    this.KeepEmptyLinesAtTheStartOfBlocks = $Prm0.KeepEmptyLinesAtTheStartOfBlocks;
    this.Language = $Prm0.Language;
    this.MacroBlockBegin.$assign($Prm0.MacroBlockBegin);
    this.MacroBlockEnd.$assign($Prm0.MacroBlockEnd);
    this.MaxEmptyLinesToKeep = $Prm0.MaxEmptyLinesToKeep;
    this.NamespaceIndentation = $Prm0.NamespaceIndentation;
    this.ObjCBlockIndentWidth = $Prm0.ObjCBlockIndentWidth;
    this.ObjCSpaceAfterProperty = $Prm0.ObjCSpaceAfterProperty;
    this.ObjCSpaceBeforeProtocolList = $Prm0.ObjCSpaceBeforeProtocolList;
    this.PenaltyBreakBeforeFirstCallParameter = $Prm0.PenaltyBreakBeforeFirstCallParameter;
    this.PenaltyBreakComment = $Prm0.PenaltyBreakComment;
    this.PenaltyBreakFirstLessLess = $Prm0.PenaltyBreakFirstLessLess;
    this.PenaltyBreakString = $Prm0.PenaltyBreakString;
    this.PenaltyExcessCharacter = $Prm0.PenaltyExcessCharacter;
    this.PenaltyReturnTypeOnItsOwnLine = $Prm0.PenaltyReturnTypeOnItsOwnLine;
    this.PointerAlignment = $Prm0.PointerAlignment;
    this.ReflowComments = $Prm0.ReflowComments;
    this.SortIncludes = $Prm0.SortIncludes;
    this.SpaceAfterCStyleCast = $Prm0.SpaceAfterCStyleCast;
    this.SpaceBeforeAssignmentOperators = $Prm0.SpaceBeforeAssignmentOperators;
    this.SpaceBeforeParens = $Prm0.SpaceBeforeParens;
    this.SpaceInEmptyParentheses = $Prm0.SpaceInEmptyParentheses;
    this.SpacesBeforeTrailingComments = $Prm0.SpacesBeforeTrailingComments;
    this.SpacesInAngles = $Prm0.SpacesInAngles;
    this.SpacesInContainerLiterals = $Prm0.SpacesInContainerLiterals;
    this.SpacesInCStyleCastParentheses = $Prm0.SpacesInCStyleCastParentheses;
    this.SpacesInParentheses = $Prm0.SpacesInParentheses;
    this.SpacesInSquareBrackets = $Prm0.SpacesInSquareBrackets;
    this.Standard = $Prm0.Standard;
    this.TabWidth = $Prm0.TabWidth;
    this.UseTab = $Prm0.UseTab;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 46,
   FQN="clang::format::FormatStyle::operator=", NM="_ZN5clang6format11FormatStyleaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyleaSEOS1_")
  //</editor-fold>
  public /*inline*/ FormatStyle /*&*/ $assignMove(final FormatStyle /*&&*/$Prm0) {
    this.AccessModifierOffset = $Prm0.AccessModifierOffset;
    this.AlignAfterOpenBracket = $Prm0.AlignAfterOpenBracket;
    this.AlignConsecutiveAssignments = $Prm0.AlignConsecutiveAssignments;
    this.AlignConsecutiveDeclarations = $Prm0.AlignConsecutiveDeclarations;
    this.AlignEscapedNewlinesLeft = $Prm0.AlignEscapedNewlinesLeft;
    this.AlignOperands = $Prm0.AlignOperands;
    this.AlignTrailingComments = $Prm0.AlignTrailingComments;
    this.AllowAllParametersOfDeclarationOnNextLine = $Prm0.AllowAllParametersOfDeclarationOnNextLine;
    this.AllowShortBlocksOnASingleLine = $Prm0.AllowShortBlocksOnASingleLine;
    this.AllowShortCaseLabelsOnASingleLine = $Prm0.AllowShortCaseLabelsOnASingleLine;
    this.AllowShortFunctionsOnASingleLine = $Prm0.AllowShortFunctionsOnASingleLine;
    this.AllowShortIfStatementsOnASingleLine = $Prm0.AllowShortIfStatementsOnASingleLine;
    this.AllowShortLoopsOnASingleLine = $Prm0.AllowShortLoopsOnASingleLine;
    this.AlwaysBreakAfterDefinitionReturnType = $Prm0.AlwaysBreakAfterDefinitionReturnType;
    this.AlwaysBreakAfterReturnType = $Prm0.AlwaysBreakAfterReturnType;
    this.AlwaysBreakBeforeMultilineStrings = $Prm0.AlwaysBreakBeforeMultilineStrings;
    this.AlwaysBreakTemplateDeclarations = $Prm0.AlwaysBreakTemplateDeclarations;
    this.BinPackArguments = $Prm0.BinPackArguments;
    this.BinPackParameters = $Prm0.BinPackParameters;
    this.BreakBeforeBinaryOperators = $Prm0.BreakBeforeBinaryOperators;
    this.BreakBeforeBraces = $Prm0.BreakBeforeBraces;
    this.BraceWrapping.$assignMove($Prm0.BraceWrapping);
    this.BreakBeforeTernaryOperators = $Prm0.BreakBeforeTernaryOperators;
    this.BreakConstructorInitializersBeforeComma = $Prm0.BreakConstructorInitializersBeforeComma;
    this.BreakAfterJavaFieldAnnotations = $Prm0.BreakAfterJavaFieldAnnotations;
    this.BreakStringLiterals = $Prm0.BreakStringLiterals;
    this.ColumnLimit = $Prm0.ColumnLimit;
    this.CommentPragmas.$assignMove($Prm0.CommentPragmas);
    this.ConstructorInitializerAllOnOneLineOrOnePerLine = $Prm0.ConstructorInitializerAllOnOneLineOrOnePerLine;
    this.ConstructorInitializerIndentWidth = $Prm0.ConstructorInitializerIndentWidth;
    this.ContinuationIndentWidth = $Prm0.ContinuationIndentWidth;
    this.Cpp11BracedListStyle = $Prm0.Cpp11BracedListStyle;
    this.DerivePointerAlignment = $Prm0.DerivePointerAlignment;
    this.DisableFormat = $Prm0.DisableFormat;
    this.ExperimentalAutoDetectBinPacking = $Prm0.ExperimentalAutoDetectBinPacking;
    this.ForEachMacros.$assignMove($Prm0.ForEachMacros);
    this.IncludeCategories.$assignMove($Prm0.IncludeCategories);
    this.IncludeIsMainRegex.$assignMove($Prm0.IncludeIsMainRegex);
    this.IndentCaseLabels = $Prm0.IndentCaseLabels;
    this.IndentWidth = $Prm0.IndentWidth;
    this.IndentWrappedFunctionNames = $Prm0.IndentWrappedFunctionNames;
    this.JavaScriptQuotes = $Prm0.JavaScriptQuotes;
    this.JavaScriptWrapImports = $Prm0.JavaScriptWrapImports;
    this.KeepEmptyLinesAtTheStartOfBlocks = $Prm0.KeepEmptyLinesAtTheStartOfBlocks;
    this.Language = $Prm0.Language;
    this.MacroBlockBegin.$assignMove($Prm0.MacroBlockBegin);
    this.MacroBlockEnd.$assignMove($Prm0.MacroBlockEnd);
    this.MaxEmptyLinesToKeep = $Prm0.MaxEmptyLinesToKeep;
    this.NamespaceIndentation = $Prm0.NamespaceIndentation;
    this.ObjCBlockIndentWidth = $Prm0.ObjCBlockIndentWidth;
    this.ObjCSpaceAfterProperty = $Prm0.ObjCSpaceAfterProperty;
    this.ObjCSpaceBeforeProtocolList = $Prm0.ObjCSpaceBeforeProtocolList;
    this.PenaltyBreakBeforeFirstCallParameter = $Prm0.PenaltyBreakBeforeFirstCallParameter;
    this.PenaltyBreakComment = $Prm0.PenaltyBreakComment;
    this.PenaltyBreakFirstLessLess = $Prm0.PenaltyBreakFirstLessLess;
    this.PenaltyBreakString = $Prm0.PenaltyBreakString;
    this.PenaltyExcessCharacter = $Prm0.PenaltyExcessCharacter;
    this.PenaltyReturnTypeOnItsOwnLine = $Prm0.PenaltyReturnTypeOnItsOwnLine;
    this.PointerAlignment = $Prm0.PointerAlignment;
    this.ReflowComments = $Prm0.ReflowComments;
    this.SortIncludes = $Prm0.SortIncludes;
    this.SpaceAfterCStyleCast = $Prm0.SpaceAfterCStyleCast;
    this.SpaceBeforeAssignmentOperators = $Prm0.SpaceBeforeAssignmentOperators;
    this.SpaceBeforeParens = $Prm0.SpaceBeforeParens;
    this.SpaceInEmptyParentheses = $Prm0.SpaceInEmptyParentheses;
    this.SpacesBeforeTrailingComments = $Prm0.SpacesBeforeTrailingComments;
    this.SpacesInAngles = $Prm0.SpacesInAngles;
    this.SpacesInContainerLiterals = $Prm0.SpacesInContainerLiterals;
    this.SpacesInCStyleCastParentheses = $Prm0.SpacesInCStyleCastParentheses;
    this.SpacesInParentheses = $Prm0.SpacesInParentheses;
    this.SpacesInSquareBrackets = $Prm0.SpacesInSquareBrackets;
    this.Standard = $Prm0.Standard;
    this.TabWidth = $Prm0.TabWidth;
    this.UseTab = $Prm0.UseTab;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::~FormatStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 46,
   FQN="clang::format::FormatStyle::~FormatStyle", NM="_ZN5clang6format11FormatStyleD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyleD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    MacroBlockEnd.$destroy();
    MacroBlockBegin.$destroy();
    IncludeIsMainRegex.$destroy();
    IncludeCategories.$destroy();
    ForEachMacros.$destroy();
    CommentPragmas.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatStyle::FormatStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 46,
   FQN="clang::format::FormatStyle::FormatStyle", NM="_ZN5clang6format11FormatStyleC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11FormatStyleC1Ev")
  //</editor-fold>
  public /*inline*/ FormatStyle() {
    // : BraceWrapping(), CommentPragmas(), ForEachMacros(), IncludeCategories(), IncludeIsMainRegex(), MacroBlockBegin(), MacroBlockEnd() 
    //START JInit
    this.BraceWrapping = new BraceWrappingFlags();
    this.CommentPragmas = new std.string();
    this.ForEachMacros = new std.vectorString(std.string.EMPTY);
    this.IncludeCategories = new std.vector<IncludeCategory>(new IncludeCategory());
    this.IncludeIsMainRegex = new std.string();
    this.MacroBlockBegin = new std.string();
    this.MacroBlockEnd = new std.string();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public org.clank.support.aliases.type$ref<LanguageKind> Language_ref = new org.clank.support.aliases.type$ref<LanguageKind>(){
    @Override
    public LanguageKind $deref() {
      return Language;
    }
  
    @Override
    public LanguageKind $set(LanguageKind value) {
      Language = value;
      return Language;
    }
  };
  
  public  org.clank.support.aliases.type$ref<DefinitionReturnTypeBreakingStyle> AlwaysBreakAfterDefinitionReturnType_ref = new  org.clank.support.aliases.type$ref<DefinitionReturnTypeBreakingStyle>(){
    @Override
    public DefinitionReturnTypeBreakingStyle $deref() {
      return AlwaysBreakAfterDefinitionReturnType;
    }
  
    @Override
    public DefinitionReturnTypeBreakingStyle $set(DefinitionReturnTypeBreakingStyle value) {
      AlwaysBreakAfterDefinitionReturnType = value;
      return AlwaysBreakAfterDefinitionReturnType;
    }
  };
  
  public  org.clank.support.aliases.type$ref<ReturnTypeBreakingStyle> AlwaysBreakAfterReturnType_ref = new  org.clank.support.aliases.type$ref<ReturnTypeBreakingStyle>(){
    @Override
    public ReturnTypeBreakingStyle $deref() {
      return AlwaysBreakAfterReturnType;
    }
  
    @Override
    public ReturnTypeBreakingStyle $set(ReturnTypeBreakingStyle value) {
      AlwaysBreakAfterReturnType = value;
      return AlwaysBreakAfterReturnType;
    }
  };

  @Override
  public FormatStyle clone() {
    return new FormatStyle(this);
  }
  public bool$ref AlwaysBreakBeforeMultilineStrings_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AlwaysBreakBeforeMultilineStrings;
    }

    @Override
    public boolean $set(boolean value) {
      AlwaysBreakBeforeMultilineStrings = value;
      return AlwaysBreakBeforeMultilineStrings;
    }
  };
  public bool$ref AlignConsecutiveAssignments_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AlignConsecutiveAssignments;
    }

    @Override
    public boolean $set(boolean value) {
      AlignConsecutiveAssignments = value;
      return AlignConsecutiveAssignments;
    }
  };
  public bool$ref AlignConsecutiveDeclarations_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AlignConsecutiveDeclarations;
    }

    @Override
    public boolean $set(boolean value) {
      AlignConsecutiveDeclarations = value;
      return AlignConsecutiveDeclarations;
    }
  };
  public bool$ref AlignEscapedNewlinesLeft_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AlignEscapedNewlinesLeft;
    }

    @Override
    public boolean $set(boolean value) {
      AlignEscapedNewlinesLeft = value;
      return AlignEscapedNewlinesLeft;
    }
  };
  public bool$ref AlignOperands_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AlignOperands;
    }

    @Override
    public boolean $set(boolean value) {
      AlignOperands = value;
      return AlignOperands;
    }
  };
  public bool$ref AlignTrailingComments_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AlignTrailingComments;
    }

    @Override
    public boolean $set(boolean value) {
      AlignTrailingComments = value;
      return AlignTrailingComments;
    }
  };
  public bool$ref AllowAllParametersOfDeclarationOnNextLine_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AllowAllParametersOfDeclarationOnNextLine;
    }

    @Override
    public boolean $set(boolean value) {
      AllowAllParametersOfDeclarationOnNextLine = value;
      return AllowAllParametersOfDeclarationOnNextLine;
    }
  };
  public bool$ref AllowShortBlocksOnASingleLine_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AllowShortBlocksOnASingleLine;
    }

    @Override
    public boolean $set(boolean value) {
      AllowShortBlocksOnASingleLine = value;
      return AllowShortBlocksOnASingleLine;
    }
  };
  public bool$ref AllowShortCaseLabelsOnASingleLine_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AllowShortCaseLabelsOnASingleLine;
    }

    @Override
    public boolean $set(boolean value) {
      AllowShortCaseLabelsOnASingleLine = value;
      return AllowShortCaseLabelsOnASingleLine;
    }
  };
  public bool$ref AllowShortIfStatementsOnASingleLine_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AllowShortIfStatementsOnASingleLine;
    }

    @Override
    public boolean $set(boolean value) {
      AllowShortIfStatementsOnASingleLine = value;
      return AllowShortIfStatementsOnASingleLine;
    }
  };
  public bool$ref AllowShortLoopsOnASingleLine_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AllowShortLoopsOnASingleLine;
    }

    @Override
    public boolean $set(boolean value) {
      AllowShortLoopsOnASingleLine = value;
      return AllowShortLoopsOnASingleLine;
    }
  };
  public bool$ref AlwaysBreakTemplateDeclarations_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return AlwaysBreakTemplateDeclarations;
    }

    @Override
    public boolean $set(boolean value) {
      AlwaysBreakTemplateDeclarations = value;
      return AlwaysBreakTemplateDeclarations;
    }
  };
  public bool$ref BinPackArguments_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return BinPackArguments;
    }

    @Override
    public boolean $set(boolean value) {
      BinPackArguments = value;
      return BinPackArguments;
    }
  };
  public bool$ref BinPackParameters_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return BinPackParameters;
    }

    @Override
    public boolean $set(boolean value) {
      BinPackParameters = value;
      return BinPackParameters;
    }
  };
  public bool$ref BreakBeforeTernaryOperators_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return BreakBeforeTernaryOperators;
    }

    @Override
    public boolean $set(boolean value) {
      BreakBeforeTernaryOperators = value;
      return BreakBeforeTernaryOperators;
    }
  };
  public bool$ref BreakConstructorInitializersBeforeComma_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return BreakConstructorInitializersBeforeComma;
    }

    @Override
    public boolean $set(boolean value) {
      BreakConstructorInitializersBeforeComma = value;
      return BreakConstructorInitializersBeforeComma;
    }
  };
  public bool$ref BreakAfterJavaFieldAnnotations_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return BreakAfterJavaFieldAnnotations;
    }

    @Override
    public boolean $set(boolean value) {
      BreakAfterJavaFieldAnnotations = value;
      return BreakAfterJavaFieldAnnotations;
    }
  };
  public bool$ref BreakStringLiterals_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return BreakStringLiterals;
    }

    @Override
    public boolean $set(boolean value) {
      BreakStringLiterals = value;
      return BreakStringLiterals;
    }
  };
  public bool$ref ConstructorInitializerAllOnOneLineOrOnePerLine_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return ConstructorInitializerAllOnOneLineOrOnePerLine;
    }

    @Override
    public boolean $set(boolean value) {
      ConstructorInitializerAllOnOneLineOrOnePerLine = value;
      return ConstructorInitializerAllOnOneLineOrOnePerLine;
    }
  };
  public bool$ref Cpp11BracedListStyle_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return Cpp11BracedListStyle;
    }

    @Override
    public boolean $set(boolean value) {
      Cpp11BracedListStyle = value;
      return Cpp11BracedListStyle;
    }
  };
  public bool$ref DerivePointerAlignment_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return DerivePointerAlignment;
    }

    @Override
    public boolean $set(boolean value) {
      DerivePointerAlignment = value;
      return DerivePointerAlignment;
    }
  };
  public bool$ref DisableFormat_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return DisableFormat;
    }

    @Override
    public boolean $set(boolean value) {
      DisableFormat = value;
      return DisableFormat;
    }
  };
  public bool$ref ExperimentalAutoDetectBinPacking_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return ExperimentalAutoDetectBinPacking;
    }

    @Override
    public boolean $set(boolean value) {
      ExperimentalAutoDetectBinPacking = value;
      return ExperimentalAutoDetectBinPacking;
    }
  };
  public bool$ref IndentCaseLabels_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return IndentCaseLabels;
    }

    @Override
    public boolean $set(boolean value) {
      IndentCaseLabels = value;
      return IndentCaseLabels;
    }
  };
  public bool$ref IndentWrappedFunctionNames_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return IndentWrappedFunctionNames;
    }

    @Override
    public boolean $set(boolean value) {
      IndentWrappedFunctionNames = value;
      return IndentWrappedFunctionNames;
    }
  };
  public bool$ref JavaScriptWrapImports_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return JavaScriptWrapImports;
    }

    @Override
    public boolean $set(boolean value) {
      JavaScriptWrapImports = value;
      return JavaScriptWrapImports;
    }
  };
  public bool$ref KeepEmptyLinesAtTheStartOfBlocks_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return KeepEmptyLinesAtTheStartOfBlocks;
    }

    @Override
    public boolean $set(boolean value) {
      KeepEmptyLinesAtTheStartOfBlocks = value;
      return KeepEmptyLinesAtTheStartOfBlocks;
    }
  };
  public bool$ref ObjCSpaceAfterProperty_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return ObjCSpaceAfterProperty;
    }

    @Override
    public boolean $set(boolean value) {
      ObjCSpaceAfterProperty = value;
      return ObjCSpaceAfterProperty;
    }
  };
  public bool$ref ObjCSpaceBeforeProtocolList_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return ObjCSpaceBeforeProtocolList;
    }

    @Override
    public boolean $set(boolean value) {
      ObjCSpaceBeforeProtocolList = value;
      return ObjCSpaceBeforeProtocolList;
    }
  };
  public bool$ref ReflowComments_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return ReflowComments;
    }

    @Override
    public boolean $set(boolean value) {
      ReflowComments = value;
      return ReflowComments;
    }
  };
  public bool$ref SortIncludes_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return SortIncludes;
    }

    @Override
    public boolean $set(boolean value) {
      SortIncludes = value;
      return SortIncludes;
    }
  };
  public bool$ref SpaceAfterCStyleCast_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return SpaceAfterCStyleCast;
    }

    @Override
    public boolean $set(boolean value) {
      SpaceAfterCStyleCast = value;
      return SpaceAfterCStyleCast;
    }
  };
  public bool$ref SpaceBeforeAssignmentOperators_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return SpaceBeforeAssignmentOperators;
    }

    @Override
    public boolean $set(boolean value) {
      SpaceBeforeAssignmentOperators = value;
      return SpaceBeforeAssignmentOperators;
    }
  };
  public bool$ref SpaceInEmptyParentheses_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return SpaceInEmptyParentheses;
    }

    @Override
    public boolean $set(boolean value) {
      SpaceInEmptyParentheses = value;
      return SpaceInEmptyParentheses;
    }
  };
  public bool$ref SpacesInAngles_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return SpacesInAngles;
    }

    @Override
    public boolean $set(boolean value) {
      SpacesInAngles = value;
      return SpacesInAngles;
    }
  };
  public bool$ref SpacesInContainerLiterals_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return SpacesInContainerLiterals;
    }

    @Override
    public boolean $set(boolean value) {
      SpacesInContainerLiterals = value;
      return SpacesInContainerLiterals;
    }
  };
  public bool$ref SpacesInCStyleCastParentheses_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return SpacesInCStyleCastParentheses;
    }

    @Override
    public boolean $set(boolean value) {
      SpacesInCStyleCastParentheses = value;
      return SpacesInCStyleCastParentheses;
    }
  };
  public bool$ref SpacesInParentheses_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return SpacesInParentheses;
    }

    @Override
    public boolean $set(boolean value) {
      SpacesInParentheses = value;
      return SpacesInParentheses;
    }
  };
  public bool$ref SpacesInSquareBrackets_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return SpacesInSquareBrackets;
    }

    @Override
    public boolean $set(boolean value) {
      SpacesInSquareBrackets = value;
      return SpacesInSquareBrackets;
    }
  };
  public int$ref AccessModifierOffset_ref = new int$ref(){
    @Override
    public int $deref() {
      return AccessModifierOffset;
    }

    @Override
    public int $set(int value) {
      AccessModifierOffset = value;
      return AccessModifierOffset;
    }
  };
  public /*uint*/uint$ref ColumnLimit_ref = new uint$ref(){
    @Override
    public int $deref() {
      return ColumnLimit;
    }

    @Override
    public int $set(int value) {
      ColumnLimit = value;
      return ColumnLimit;
    }
  };
  public /*uint*/uint$ref ConstructorInitializerIndentWidth_ref = new uint$ref(){
    @Override
    public int $deref() {
      return ConstructorInitializerIndentWidth;
    }

    @Override
    public int $set(int value) {
      ConstructorInitializerIndentWidth = value;
      return ConstructorInitializerIndentWidth;
    }
  };
  public /*uint*/uint$ref ContinuationIndentWidth_ref = new uint$ref(){
    @Override
    public int $deref() {
      return ContinuationIndentWidth;
    }

    @Override
    public int $set(int value) {
      ContinuationIndentWidth = value;
      return ContinuationIndentWidth;
    }
  };
  public /*uint*/uint$ref IndentWidth_ref = new uint$ref(){
    @Override
    public int $deref() {
      return IndentWidth;
    }

    @Override
    public int $set(int value) {
      IndentWidth = value;
      return IndentWidth;
    }
  };
  public /*uint*/uint$ref MaxEmptyLinesToKeep_ref = new uint$ref(){
    @Override
    public int $deref() {
      return MaxEmptyLinesToKeep;
    }

    @Override
    public int $set(int value) {
      MaxEmptyLinesToKeep = value;
      return MaxEmptyLinesToKeep;
    }
  };
  public /*uint*/uint$ref ObjCBlockIndentWidth_ref = new uint$ref(){
    @Override
    public int $deref() {
      return ObjCBlockIndentWidth;
    }

    @Override
    public int $set(int value) {
      ObjCBlockIndentWidth = value;
      return ObjCBlockIndentWidth;
    }
  };
  public /*uint*/uint$ref PenaltyBreakBeforeFirstCallParameter_ref = new uint$ref(){
    @Override
    public int $deref() {
      return PenaltyBreakBeforeFirstCallParameter;
    }

    @Override
    public int $set(int value) {
      PenaltyBreakBeforeFirstCallParameter = value;
      return PenaltyBreakBeforeFirstCallParameter;
    }
  };
  public /*uint*/uint$ref PenaltyBreakComment_ref = new uint$ref(){
    @Override
    public int $deref() {
      return PenaltyBreakComment;
    }

    @Override
    public int $set(int value) {
      PenaltyBreakComment = value;
      return PenaltyBreakComment;
    }
  };
  public /*uint*/uint$ref PenaltyBreakFirstLessLess_ref = new uint$ref(){
    @Override
    public int $deref() {
      return PenaltyBreakFirstLessLess;
    }

    @Override
    public int $set(int value) {
      PenaltyBreakFirstLessLess = value;
      return PenaltyBreakFirstLessLess;
    }
  };
  public /*uint*/uint$ref PenaltyBreakString_ref = new uint$ref(){
    @Override
    public int $deref() {
      return PenaltyBreakString;
    }

    @Override
    public int $set(int value) {
      PenaltyBreakString = value;
      return PenaltyBreakString;
    }
  };
  public /*uint*/uint$ref PenaltyExcessCharacter_ref = new uint$ref(){
    @Override
    public int $deref() {
      return PenaltyExcessCharacter;
    }

    @Override
    public int $set(int value) {
      PenaltyExcessCharacter = value;
      return PenaltyExcessCharacter;
    }
  };
  public /*uint*/uint$ref PenaltyReturnTypeOnItsOwnLine_ref = new uint$ref(){
    @Override
    public int $deref() {
      return PenaltyReturnTypeOnItsOwnLine;
    }

    @Override
    public int $set(int value) {
      PenaltyReturnTypeOnItsOwnLine = value;
      return PenaltyReturnTypeOnItsOwnLine;
    }
  };
  public /*uint*/uint$ref SpacesBeforeTrailingComments_ref = new uint$ref(){
    @Override
    public int $deref() {
      return SpacesBeforeTrailingComments;
    }

    @Override
    public int $set(int value) {
      SpacesBeforeTrailingComments = value;
      return SpacesBeforeTrailingComments;
    }
  };
  public /*uint*/uint$ref TabWidth_ref = new uint$ref(){
    @Override
    public int $deref() {
      return TabWidth;
    }

    @Override
    public int $set(int value) {
      TabWidth = value;
      return TabWidth;
    }
  };
  public type$ref<BracketAlignmentStyle> AlignAfterOpenBracket_ref = new type$ref<BracketAlignmentStyle>(){
    @Override
    public BracketAlignmentStyle $deref() {
      return AlignAfterOpenBracket;
    }

    @Override
    public BracketAlignmentStyle $set(BracketAlignmentStyle value) {
      AlignAfterOpenBracket = value;
      return AlignAfterOpenBracket;
    }
  };
  public type$ref<ShortFunctionStyle> AllowShortFunctionsOnASingleLine_ref = new type$ref<ShortFunctionStyle>(){
    @Override
    public ShortFunctionStyle $deref() {
      return AllowShortFunctionsOnASingleLine;
    }

    @Override
    public ShortFunctionStyle $set(ShortFunctionStyle value) {
      AllowShortFunctionsOnASingleLine = value;
      return AllowShortFunctionsOnASingleLine;
    }
  };
  public type$ref<BinaryOperatorStyle> BreakBeforeBinaryOperators_ref = new type$ref<BinaryOperatorStyle>(){
    @Override
    public BinaryOperatorStyle $deref() {
      return  BreakBeforeBinaryOperators;
    }

    @Override
    public BinaryOperatorStyle $set(BinaryOperatorStyle value) {
      BreakBeforeBinaryOperators = value;
      return  BreakBeforeBinaryOperators;
    }
  };
  public type$ref<BraceBreakingStyle> BreakBeforeBraces_ref = new type$ref<BraceBreakingStyle>(){
    @Override
    public BraceBreakingStyle $deref() {
      return BreakBeforeBraces;
    }

    @Override
    public BraceBreakingStyle $set(BraceBreakingStyle value) {
      BreakBeforeBraces = value;
      return BreakBeforeBraces;
    }
  };
  public type$ref<JavaScriptQuoteStyle> JavaScriptQuotes_ref = new type$ref<JavaScriptQuoteStyle>(){
    @Override
    public JavaScriptQuoteStyle $deref() {
      return JavaScriptQuotes;
    }

    @Override
    public JavaScriptQuoteStyle $set(JavaScriptQuoteStyle value) {
      JavaScriptQuotes = value;
      return JavaScriptQuotes;
    }
  };
  public type$ref<NamespaceIndentationKind> NamespaceIndentation_ref = new type$ref<NamespaceIndentationKind>(){
    @Override
    public NamespaceIndentationKind $deref() {
      return NamespaceIndentation;
    }

    @Override
    public NamespaceIndentationKind $set(NamespaceIndentationKind value) {
      NamespaceIndentation = value;
      return NamespaceIndentation;
    }
  };
  public type$ref<PointerAlignmentStyle> PointerAlignment_ref = new type$ref<PointerAlignmentStyle>(){
    @Override
    public PointerAlignmentStyle $deref() {
      return PointerAlignment;
    }

    @Override
    public PointerAlignmentStyle $set(PointerAlignmentStyle value) {
      PointerAlignment = value;
      return PointerAlignment;
    }
  };
  public type$ref<SpaceBeforeParensOptions> SpaceBeforeParens_ref = new type$ref<SpaceBeforeParensOptions>(){
    @Override
    public SpaceBeforeParensOptions $deref() {
      return SpaceBeforeParens;
    }

    @Override
    public SpaceBeforeParensOptions $set(SpaceBeforeParensOptions value) {
      SpaceBeforeParens = value;
      return SpaceBeforeParens;
    }
  };
  public type$ref<LanguageStandard> Standard_ref = new type$ref<LanguageStandard>(){
    @Override
    public LanguageStandard $deref() {
      return Standard;
    }

    @Override
    public LanguageStandard $set(LanguageStandard value) {
      Standard = value;
      return Standard;
    }
  };
  public type$ref<UseTabStyle> UseTab_ref = new type$ref<UseTabStyle>(){
    @Override
    public UseTabStyle $deref() {
      return UseTab;
    }

    @Override
    public UseTabStyle $set(UseTabStyle value) {
      UseTab = value;
      return UseTab;
    }
  };
  //public std.string CommentPragmas;
  //public std.string MacroBlockBegin;
  //public std.string MacroBlockEnd;
  //public std.string IncludeIsMainRegex;
  //public std.vectorString ForEachMacros;
  //public std.vector<IncludeCategory> IncludeCategories;
  //public BraceWrappingFlags BraceWrapping;
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "AccessModifierOffset=" + AccessModifierOffset // NOI18N
              + ", AlignAfterOpenBracket=" + AlignAfterOpenBracket // NOI18N
              + ", AlignConsecutiveAssignments=" + AlignConsecutiveAssignments // NOI18N
              + ", AlignConsecutiveDeclarations=" + AlignConsecutiveDeclarations // NOI18N
              + ", AlignEscapedNewlinesLeft=" + AlignEscapedNewlinesLeft // NOI18N
              + ", AlignOperands=" + AlignOperands // NOI18N
              + ", AlignTrailingComments=" + AlignTrailingComments // NOI18N
              + ", AllowAllParametersOfDeclarationOnNextLine=" + AllowAllParametersOfDeclarationOnNextLine // NOI18N
              + ", AllowShortBlocksOnASingleLine=" + AllowShortBlocksOnASingleLine // NOI18N
              + ", AllowShortCaseLabelsOnASingleLine=" + AllowShortCaseLabelsOnASingleLine // NOI18N
              + ", AllowShortFunctionsOnASingleLine=" + AllowShortFunctionsOnASingleLine // NOI18N
              + ", AllowShortIfStatementsOnASingleLine=" + AllowShortIfStatementsOnASingleLine // NOI18N
              + ", AllowShortLoopsOnASingleLine=" + AllowShortLoopsOnASingleLine // NOI18N
              + ", AlwaysBreakAfterDefinitionReturnType=" + AlwaysBreakAfterDefinitionReturnType // NOI18N
              + ", AlwaysBreakAfterReturnType=" + AlwaysBreakAfterReturnType // NOI18N
              + ", AlwaysBreakBeforeMultilineStrings=" + AlwaysBreakBeforeMultilineStrings // NOI18N
              + ", AlwaysBreakTemplateDeclarations=" + AlwaysBreakTemplateDeclarations // NOI18N
              + ", BinPackArguments=" + BinPackArguments // NOI18N
              + ", BinPackParameters=" + BinPackParameters // NOI18N
              + ", BreakBeforeBinaryOperators=" + BreakBeforeBinaryOperators // NOI18N
              + ", BreakBeforeBraces=" + BreakBeforeBraces // NOI18N
              + ", BraceWrapping=" + BraceWrapping // NOI18N
              + ", BreakBeforeTernaryOperators=" + BreakBeforeTernaryOperators // NOI18N
              + ", BreakConstructorInitializersBeforeComma=" + BreakConstructorInitializersBeforeComma // NOI18N
              + ", BreakAfterJavaFieldAnnotations=" + BreakAfterJavaFieldAnnotations // NOI18N
              + ", BreakStringLiterals=" + BreakStringLiterals // NOI18N
              + ", ColumnLimit=" + ColumnLimit // NOI18N
              + ", CommentPragmas=" + CommentPragmas // NOI18N
              + ", ConstructorInitializerAllOnOneLineOrOnePerLine=" + ConstructorInitializerAllOnOneLineOrOnePerLine // NOI18N
              + ", ConstructorInitializerIndentWidth=" + ConstructorInitializerIndentWidth // NOI18N
              + ", ContinuationIndentWidth=" + ContinuationIndentWidth // NOI18N
              + ", Cpp11BracedListStyle=" + Cpp11BracedListStyle // NOI18N
              + ", DerivePointerAlignment=" + DerivePointerAlignment // NOI18N
              + ", DisableFormat=" + DisableFormat // NOI18N
              + ", ExperimentalAutoDetectBinPacking=" + ExperimentalAutoDetectBinPacking // NOI18N
              + ", ForEachMacros=" + ForEachMacros // NOI18N
              + ", IncludeCategories=" + IncludeCategories // NOI18N
              + ", IncludeIsMainRegex=" + IncludeIsMainRegex // NOI18N
              + ", IndentCaseLabels=" + IndentCaseLabels // NOI18N
              + ", IndentWidth=" + IndentWidth // NOI18N
              + ", IndentWrappedFunctionNames=" + IndentWrappedFunctionNames // NOI18N
              + ", JavaScriptQuotes=" + JavaScriptQuotes // NOI18N
              + ", JavaScriptWrapImports=" + JavaScriptWrapImports // NOI18N
              + ", KeepEmptyLinesAtTheStartOfBlocks=" + KeepEmptyLinesAtTheStartOfBlocks // NOI18N
              + ", Language=" + Language // NOI18N
              + ", MacroBlockBegin=" + MacroBlockBegin // NOI18N
              + ", MacroBlockEnd=" + MacroBlockEnd // NOI18N
              + ", MaxEmptyLinesToKeep=" + MaxEmptyLinesToKeep // NOI18N
              + ", NamespaceIndentation=" + NamespaceIndentation // NOI18N
              + ", ObjCBlockIndentWidth=" + ObjCBlockIndentWidth // NOI18N
              + ", ObjCSpaceAfterProperty=" + ObjCSpaceAfterProperty // NOI18N
              + ", ObjCSpaceBeforeProtocolList=" + ObjCSpaceBeforeProtocolList // NOI18N
              + ", PenaltyBreakBeforeFirstCallParameter=" + PenaltyBreakBeforeFirstCallParameter // NOI18N
              + ", PenaltyBreakComment=" + PenaltyBreakComment // NOI18N
              + ", PenaltyBreakFirstLessLess=" + PenaltyBreakFirstLessLess // NOI18N
              + ", PenaltyBreakString=" + PenaltyBreakString // NOI18N
              + ", PenaltyExcessCharacter=" + PenaltyExcessCharacter // NOI18N
              + ", PenaltyReturnTypeOnItsOwnLine=" + PenaltyReturnTypeOnItsOwnLine // NOI18N
              + ", PointerAlignment=" + PointerAlignment // NOI18N
              + ", ReflowComments=" + ReflowComments // NOI18N
              + ", SortIncludes=" + SortIncludes // NOI18N
              + ", SpaceAfterCStyleCast=" + SpaceAfterCStyleCast // NOI18N
              + ", SpaceBeforeAssignmentOperators=" + SpaceBeforeAssignmentOperators // NOI18N
              + ", SpaceBeforeParens=" + SpaceBeforeParens // NOI18N
              + ", SpaceInEmptyParentheses=" + SpaceInEmptyParentheses // NOI18N
              + ", SpacesBeforeTrailingComments=" + SpacesBeforeTrailingComments // NOI18N
              + ", SpacesInAngles=" + SpacesInAngles // NOI18N
              + ", SpacesInContainerLiterals=" + SpacesInContainerLiterals // NOI18N
              + ", SpacesInCStyleCastParentheses=" + SpacesInCStyleCastParentheses // NOI18N
              + ", SpacesInParentheses=" + SpacesInParentheses // NOI18N
              + ", SpacesInSquareBrackets=" + SpacesInSquareBrackets // NOI18N
              + ", Standard=" + Standard // NOI18N
              + ", TabWidth=" + TabWidth // NOI18N
              + ", UseTab=" + UseTab; // NOI18N
  }
}
