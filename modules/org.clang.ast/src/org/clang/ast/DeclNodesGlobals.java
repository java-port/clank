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
package org.clang.ast;

import org.clank.support.*;


//<editor-fold defaultstate="collapsed" desc="static type DeclNodesGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL10nCaptureds;_ZL10nFunctions;_ZL10nObjCIvars;_ZL11nCXXMethods;_ZL11nCXXRecords;_ZL11nNamespaces;_ZL11nTypeAliass;_ZL12nAccessSpecs;_ZL12nMSPropertys;_ZL12nObjCMethods;_ZL13nLinkageSpecs;_ZL13nUsingShadows;_ZL13nVarTemplates;_ZL14nEnumConstants;_ZL14nFileScopeAsms;_ZL14nObjCCategorys;_ZL14nObjCPropertys;_ZL14nObjCProtocols;_ZL14nStaticAsserts;_ZL15nCXXConversions;_ZL15nCXXDestructors;_ZL15nClassTemplates;_ZL15nImplicitParams;_ZL15nIndirectFields;_ZL15nObjCInterfaces;_ZL15nObjCTypeParams;_ZL15nPragmaComments;_ZL16nCXXConstructors;_ZL16nExternCContexts;_ZL16nFriendTemplates;_ZL16nNamespaceAliass;_ZL16nUsingDirectives;_ZL17nBuiltinTemplates;_ZL17nOMPCapturedExprs;_ZL17nObjCAtDefsFields;_ZL17nTranslationUnits;_ZL18nFunctionTemplates;_ZL18nOMPThreadPrivates;_ZL18nObjCCategoryImpls;_ZL18nObjCPropertyImpls;_ZL18nTemplateTypeParms;_ZL19nTypeAliasTemplates;_ZL20nObjCImplementations;_ZL21nNonTypeTemplateParms;_ZL21nOMPDeclareReductions;_ZL21nObjCCompatibleAliass;_ZL22nPragmaDetectMismatchs;_ZL22nTemplateTemplateParms;_ZL22nUnresolvedUsingValues;_ZL24nConstructorUsingShadows;_ZL25nUnresolvedUsingTypenames;_ZL27nVarTemplateSpecializations;_ZL29nClassTemplateSpecializations;_ZL34nClassScopeFunctionSpecializations;_ZL34nVarTemplatePartialSpecializations;_ZL36nClassTemplatePartialSpecializations;_ZL5nVars;_ZL6nEnums;_ZL7nBlocks;_ZL7nEmptys;_ZL7nFields;_ZL7nLabels;_ZL7nUsings;_ZL8nFriends;_ZL8nImports;_ZL8nRecords;_ZL9nParmVars;_ZL9nTypedefs; -static-type=DeclNodesGlobals -package=org.clang.ast")
//</editor-fold>
public final class DeclNodesGlobals {

//<editor-fold defaultstate="collapsed" desc="nAccessSpecs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 23,
 FQN="nAccessSpecs", NM="_ZL12nAccessSpecs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL12nAccessSpecs")
//</editor-fold>
public static int nAccessSpecs = 0;
//<editor-fold defaultstate="collapsed" desc="nBlocks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 29,
 FQN="nBlocks", NM="_ZL7nBlocks",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL7nBlocks")
//</editor-fold>
public static int nBlocks = 0;
//<editor-fold defaultstate="collapsed" desc="nCaptureds">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 35,
 FQN="nCaptureds", NM="_ZL10nCaptureds",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL10nCaptureds")
//</editor-fold>
public static int nCaptureds = 0;
//<editor-fold defaultstate="collapsed" desc="nClassScopeFunctionSpecializations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 41,
 FQN="nClassScopeFunctionSpecializations", NM="_ZL34nClassScopeFunctionSpecializations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL34nClassScopeFunctionSpecializations")
//</editor-fold>
public static int nClassScopeFunctionSpecializations = 0;
//<editor-fold defaultstate="collapsed" desc="nEmptys">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 47,
 FQN="nEmptys", NM="_ZL7nEmptys",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL7nEmptys")
//</editor-fold>
public static int nEmptys = 0;
//<editor-fold defaultstate="collapsed" desc="nExternCContexts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 53,
 FQN="nExternCContexts", NM="_ZL16nExternCContexts",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL16nExternCContexts")
//</editor-fold>
public static int nExternCContexts = 0;
//<editor-fold defaultstate="collapsed" desc="nFileScopeAsms">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 59,
 FQN="nFileScopeAsms", NM="_ZL14nFileScopeAsms",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL14nFileScopeAsms")
//</editor-fold>
public static int nFileScopeAsms = 0;
//<editor-fold defaultstate="collapsed" desc="nFriends">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 65,
 FQN="nFriends", NM="_ZL8nFriends",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL8nFriends")
//</editor-fold>
public static int nFriends = 0;
//<editor-fold defaultstate="collapsed" desc="nFriendTemplates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 71,
 FQN="nFriendTemplates", NM="_ZL16nFriendTemplates",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL16nFriendTemplates")
//</editor-fold>
public static int nFriendTemplates = 0;
//<editor-fold defaultstate="collapsed" desc="nImports">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 77,
 FQN="nImports", NM="_ZL8nImports",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL8nImports")
//</editor-fold>
public static int nImports = 0;
//<editor-fold defaultstate="collapsed" desc="nLinkageSpecs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 83,
 FQN="nLinkageSpecs", NM="_ZL13nLinkageSpecs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL13nLinkageSpecs")
//</editor-fold>
public static int nLinkageSpecs = 0;
//<editor-fold defaultstate="collapsed" desc="nLabels">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 93,
 FQN="nLabels", NM="_ZL7nLabels",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL7nLabels")
//</editor-fold>
public static int nLabels = 0;
//<editor-fold defaultstate="collapsed" desc="nNamespaces">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 99,
 FQN="nNamespaces", NM="_ZL11nNamespaces",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL11nNamespaces")
//</editor-fold>
public static int nNamespaces = 0;
//<editor-fold defaultstate="collapsed" desc="nNamespaceAliass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 105,
 FQN="nNamespaceAliass", NM="_ZL16nNamespaceAliass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL16nNamespaceAliass")
//</editor-fold>
public static int nNamespaceAliass = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCCompatibleAliass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 111,
 FQN="nObjCCompatibleAliass", NM="_ZL21nObjCCompatibleAliass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL21nObjCCompatibleAliass")
//</editor-fold>
public static int nObjCCompatibleAliass = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCCategorys">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 121,
 FQN="nObjCCategorys", NM="_ZL14nObjCCategorys",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL14nObjCCategorys")
//</editor-fold>
public static int nObjCCategorys = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCCategoryImpls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 131,
 FQN="nObjCCategoryImpls", NM="_ZL18nObjCCategoryImpls",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL18nObjCCategoryImpls")
//</editor-fold>
public static int nObjCCategoryImpls = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCImplementations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 137,
 FQN="nObjCImplementations", NM="_ZL20nObjCImplementations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL20nObjCImplementations")
//</editor-fold>
public static int nObjCImplementations = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCInterfaces">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 147,
 FQN="nObjCInterfaces", NM="_ZL15nObjCInterfaces",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL15nObjCInterfaces")
//</editor-fold>
public static int nObjCInterfaces = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCProtocols">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 153,
 FQN="nObjCProtocols", NM="_ZL14nObjCProtocols",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL14nObjCProtocols")
//</editor-fold>
public static int nObjCProtocols = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 163,
 FQN="nObjCMethods", NM="_ZL12nObjCMethods",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL12nObjCMethods")
//</editor-fold>
public static int nObjCMethods = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCPropertys">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 169,
 FQN="nObjCPropertys", NM="_ZL14nObjCPropertys",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL14nObjCPropertys")
//</editor-fold>
public static int nObjCPropertys = 0;
//<editor-fold defaultstate="collapsed" desc="nBuiltinTemplates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 179,
 FQN="nBuiltinTemplates", NM="_ZL17nBuiltinTemplates",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL17nBuiltinTemplates")
//</editor-fold>
public static int nBuiltinTemplates = 0;
//<editor-fold defaultstate="collapsed" desc="nClassTemplates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 189,
 FQN="nClassTemplates", NM="_ZL15nClassTemplates",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL15nClassTemplates")
//</editor-fold>
public static int nClassTemplates = 0;
//<editor-fold defaultstate="collapsed" desc="nFunctionTemplates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 195,
 FQN="nFunctionTemplates", NM="_ZL18nFunctionTemplates",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL18nFunctionTemplates")
//</editor-fold>
public static int nFunctionTemplates = 0;
//<editor-fold defaultstate="collapsed" desc="nTypeAliasTemplates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 201,
 FQN="nTypeAliasTemplates", NM="_ZL19nTypeAliasTemplates",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL19nTypeAliasTemplates")
//</editor-fold>
public static int nTypeAliasTemplates = 0;
//<editor-fold defaultstate="collapsed" desc="nVarTemplates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 207,
 FQN="nVarTemplates", NM="_ZL13nVarTemplates",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL13nVarTemplates")
//</editor-fold>
public static int nVarTemplates = 0;
//<editor-fold defaultstate="collapsed" desc="nTemplateTemplateParms">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 217,
 FQN="nTemplateTemplateParms", NM="_ZL22nTemplateTemplateParms",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL22nTemplateTemplateParms")
//</editor-fold>
public static int nTemplateTemplateParms = 0;
//<editor-fold defaultstate="collapsed" desc="nEnums">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 235,
 FQN="nEnums", NM="_ZL6nEnums",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL6nEnums")
//</editor-fold>
public static int nEnums = 0;
//<editor-fold defaultstate="collapsed" desc="nRecords">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 241,
 FQN="nRecords", NM="_ZL8nRecords",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL8nRecords")
//</editor-fold>
public static int nRecords = 0;
//<editor-fold defaultstate="collapsed" desc="nCXXRecords">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 245,
 FQN="nCXXRecords", NM="_ZL11nCXXRecords",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL11nCXXRecords")
//</editor-fold>
public static int nCXXRecords = 0;
//<editor-fold defaultstate="collapsed" desc="nClassTemplateSpecializations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 249,
 FQN="nClassTemplateSpecializations", NM="_ZL29nClassTemplateSpecializations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL29nClassTemplateSpecializations")
//</editor-fold>
public static int nClassTemplateSpecializations = 0;
//<editor-fold defaultstate="collapsed" desc="nClassTemplatePartialSpecializations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 253,
 FQN="nClassTemplatePartialSpecializations", NM="_ZL36nClassTemplatePartialSpecializations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL36nClassTemplatePartialSpecializations")
//</editor-fold>
public static int nClassTemplatePartialSpecializations = 0;
//<editor-fold defaultstate="collapsed" desc="nTemplateTypeParms">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 275,
 FQN="nTemplateTypeParms", NM="_ZL18nTemplateTypeParms",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL18nTemplateTypeParms")
//</editor-fold>
public static int nTemplateTypeParms = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCTypeParams">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 285,
 FQN="nObjCTypeParams", NM="_ZL15nObjCTypeParams",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL15nObjCTypeParams")
//</editor-fold>
public static int nObjCTypeParams = 0;
//<editor-fold defaultstate="collapsed" desc="nTypeAliass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 291,
 FQN="nTypeAliass", NM="_ZL11nTypeAliass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL11nTypeAliass")
//</editor-fold>
public static int nTypeAliass = 0;
//<editor-fold defaultstate="collapsed" desc="nTypedefs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 297,
 FQN="nTypedefs", NM="_ZL9nTypedefs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL9nTypedefs")
//</editor-fold>
public static int nTypedefs = 0;
//<editor-fold defaultstate="collapsed" desc="nUnresolvedUsingTypenames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 307,
 FQN="nUnresolvedUsingTypenames", NM="_ZL25nUnresolvedUsingTypenames",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL25nUnresolvedUsingTypenames")
//</editor-fold>
public static int nUnresolvedUsingTypenames = 0;
//<editor-fold defaultstate="collapsed" desc="nUsings">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 317,
 FQN="nUsings", NM="_ZL7nUsings",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL7nUsings")
//</editor-fold>
public static int nUsings = 0;
//<editor-fold defaultstate="collapsed" desc="nUsingDirectives">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 323,
 FQN="nUsingDirectives", NM="_ZL16nUsingDirectives",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL16nUsingDirectives")
//</editor-fold>
public static int nUsingDirectives = 0;
//<editor-fold defaultstate="collapsed" desc="nUsingShadows">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 329,
 FQN="nUsingShadows", NM="_ZL13nUsingShadows",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL13nUsingShadows")
//</editor-fold>
public static int nUsingShadows = 0;
//<editor-fold defaultstate="collapsed" desc="nConstructorUsingShadows">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 333,
 FQN="nConstructorUsingShadows", NM="_ZL24nConstructorUsingShadows",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL24nConstructorUsingShadows")
//</editor-fold>
public static int nConstructorUsingShadows = 0;
//<editor-fold defaultstate="collapsed" desc="nFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 351,
 FQN="nFields", NM="_ZL7nFields",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL7nFields")
//</editor-fold>
public static int nFields = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCAtDefsFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 355,
 FQN="nObjCAtDefsFields", NM="_ZL17nObjCAtDefsFields",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL17nObjCAtDefsFields")
//</editor-fold>
public static int nObjCAtDefsFields = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCIvars">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 361,
 FQN="nObjCIvars", NM="_ZL10nObjCIvars",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL10nObjCIvars")
//</editor-fold>
public static int nObjCIvars = 0;
//<editor-fold defaultstate="collapsed" desc="nFunctions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 371,
 FQN="nFunctions", NM="_ZL10nFunctions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL10nFunctions")
//</editor-fold>
public static int nFunctions = 0;
//<editor-fold defaultstate="collapsed" desc="nCXXMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 375,
 FQN="nCXXMethods", NM="_ZL11nCXXMethods",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL11nCXXMethods")
//</editor-fold>
public static int nCXXMethods = 0;
//<editor-fold defaultstate="collapsed" desc="nCXXConstructors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 379,
 FQN="nCXXConstructors", NM="_ZL16nCXXConstructors",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL16nCXXConstructors")
//</editor-fold>
public static int nCXXConstructors = 0;
//<editor-fold defaultstate="collapsed" desc="nCXXConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 385,
 FQN="nCXXConversions", NM="_ZL15nCXXConversions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL15nCXXConversions")
//</editor-fold>
public static int nCXXConversions = 0;
//<editor-fold defaultstate="collapsed" desc="nCXXDestructors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 391,
 FQN="nCXXDestructors", NM="_ZL15nCXXDestructors",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL15nCXXDestructors")
//</editor-fold>
public static int nCXXDestructors = 0;
//<editor-fold defaultstate="collapsed" desc="nMSPropertys">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 405,
 FQN="nMSPropertys", NM="_ZL12nMSPropertys",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL12nMSPropertys")
//</editor-fold>
public static int nMSPropertys = 0;
//<editor-fold defaultstate="collapsed" desc="nNonTypeTemplateParms">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 411,
 FQN="nNonTypeTemplateParms", NM="_ZL21nNonTypeTemplateParms",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL21nNonTypeTemplateParms")
//</editor-fold>
public static int nNonTypeTemplateParms = 0;
//<editor-fold defaultstate="collapsed" desc="nVars">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 417,
 FQN="nVars", NM="_ZL5nVars",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL5nVars")
//</editor-fold>
public static int nVars = 0;
//<editor-fold defaultstate="collapsed" desc="nImplicitParams">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 421,
 FQN="nImplicitParams", NM="_ZL15nImplicitParams",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL15nImplicitParams")
//</editor-fold>
public static int nImplicitParams = 0;
//<editor-fold defaultstate="collapsed" desc="nOMPCapturedExprs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 427,
 FQN="nOMPCapturedExprs", NM="_ZL17nOMPCapturedExprs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL17nOMPCapturedExprs")
//</editor-fold>
public static int nOMPCapturedExprs = 0;
//<editor-fold defaultstate="collapsed" desc="nParmVars">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 433,
 FQN="nParmVars", NM="_ZL9nParmVars",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL9nParmVars")
//</editor-fold>
public static int nParmVars = 0;
//<editor-fold defaultstate="collapsed" desc="nVarTemplateSpecializations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 439,
 FQN="nVarTemplateSpecializations", NM="_ZL27nVarTemplateSpecializations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL27nVarTemplateSpecializations")
//</editor-fold>
public static int nVarTemplateSpecializations = 0;
//<editor-fold defaultstate="collapsed" desc="nVarTemplatePartialSpecializations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 443,
 FQN="nVarTemplatePartialSpecializations", NM="_ZL34nVarTemplatePartialSpecializations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL34nVarTemplatePartialSpecializations")
//</editor-fold>
public static int nVarTemplatePartialSpecializations = 0;
//<editor-fold defaultstate="collapsed" desc="nEnumConstants">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 461,
 FQN="nEnumConstants", NM="_ZL14nEnumConstants",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL14nEnumConstants")
//</editor-fold>
public static int nEnumConstants = 0;
//<editor-fold defaultstate="collapsed" desc="nIndirectFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 467,
 FQN="nIndirectFields", NM="_ZL15nIndirectFields",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL15nIndirectFields")
//</editor-fold>
public static int nIndirectFields = 0;
//<editor-fold defaultstate="collapsed" desc="nOMPDeclareReductions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 473,
 FQN="nOMPDeclareReductions", NM="_ZL21nOMPDeclareReductions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL21nOMPDeclareReductions")
//</editor-fold>
public static int nOMPDeclareReductions = 0;
//<editor-fold defaultstate="collapsed" desc="nUnresolvedUsingValues">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 479,
 FQN="nUnresolvedUsingValues", NM="_ZL22nUnresolvedUsingValues",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL22nUnresolvedUsingValues")
//</editor-fold>
public static int nUnresolvedUsingValues = 0;
//<editor-fold defaultstate="collapsed" desc="nOMPThreadPrivates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 493,
 FQN="nOMPThreadPrivates", NM="_ZL18nOMPThreadPrivates",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL18nOMPThreadPrivates")
//</editor-fold>
public static int nOMPThreadPrivates = 0;
//<editor-fold defaultstate="collapsed" desc="nObjCPropertyImpls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 499,
 FQN="nObjCPropertyImpls", NM="_ZL18nObjCPropertyImpls",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL18nObjCPropertyImpls")
//</editor-fold>
public static int nObjCPropertyImpls = 0;
//<editor-fold defaultstate="collapsed" desc="nPragmaComments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 505,
 FQN="nPragmaComments", NM="_ZL15nPragmaComments",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL15nPragmaComments")
//</editor-fold>
public static int nPragmaComments = 0;
//<editor-fold defaultstate="collapsed" desc="nPragmaDetectMismatchs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 511,
 FQN="nPragmaDetectMismatchs", NM="_ZL22nPragmaDetectMismatchs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL22nPragmaDetectMismatchs")
//</editor-fold>
public static int nPragmaDetectMismatchs = 0;
//<editor-fold defaultstate="collapsed" desc="nStaticAsserts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 517,
 FQN="nStaticAsserts", NM="_ZL14nStaticAsserts",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL14nStaticAsserts")
//</editor-fold>
public static int nStaticAsserts = 0;
//<editor-fold defaultstate="collapsed" desc="nTranslationUnits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 523,
 FQN="nTranslationUnits", NM="_ZL17nTranslationUnits",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL17nTranslationUnits")
//</editor-fold>
public static int nTranslationUnits = 0;
} // END OF class DeclNodesGlobals
