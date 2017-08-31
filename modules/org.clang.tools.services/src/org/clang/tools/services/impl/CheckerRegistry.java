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

package org.clang.tools.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import org.clang.frontend.InputKind;
import org.clang.tools.services.checkers.api.ClankChecker;
import org.clang.tools.services.spi.ClankCheckerProvider;
import org.clang.tools.services.support.Utilitites;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author masha
 */
public final class CheckerRegistry {

  private static final ArrayList<ClankChecker> checkers = new ArrayList<>();

  static {
    checkers.add(ClankCheckerBuilder.build("core", "core"));
    checkers.add(ClankCheckerBuilder.build("core.CallAndMessage", "core.CallAndMessage"));
    checkers.add(ClankCheckerBuilder.build("core.DivideZero", "core.DivideZero"));
    checkers.add(ClankCheckerBuilder.build("core.NonNullParamChecker", "core.NonNullParamChecker"));
    checkers.add(ClankCheckerBuilder.build("core.NullDereference", "core.NullDereference"));
    checkers.add(ClankCheckerBuilder.build("core.StackAddressEscape", "core.StackAddressEscape"));
    checkers.add(ClankCheckerBuilder.build("core.UndefinedBinaryOperatorResult", "core.UndefinedBinaryOperatorResult"));
    checkers.add(ClankCheckerBuilder.build("core.VLASize", "core.VLASize"));
    checkers.add(ClankCheckerBuilder.build("core.uninitialized.ArraySubscript", "core.uninitialized.ArraySubscript"));
    checkers.add(ClankCheckerBuilder.build("core.uninitialized.Assign", "core.uninitialized.Assign"));
    checkers.add(ClankCheckerBuilder.build("core.uninitialized.Branch", "core.uninitialized.Branch"));
    checkers.add(ClankCheckerBuilder.build("core.uninitialized.CapturedBlockVariable", "core.uninitialized.CapturedBlockVariable"));
    checkers.add(ClankCheckerBuilder.build("core.uninitialized.UndefReturn", "core.uninitialized.UndefReturn"));
    checkers.add(ClankCheckerBuilder.build("cplusplus.NewDelete", "cplusplus.NewDelete"));
    checkers.add(ClankCheckerBuilder.build("deadcode.DeadStores", "deadcode.DeadStores"));
    checkers.add(ClankCheckerBuilder.build("security", "security"));
    checkers.add(ClankCheckerBuilder.build("security.FloatLoopCounter", "security.FloatLoopCounter"));
    checkers.add(ClankCheckerBuilder.build("security.insecureAPI.UncheckedReturn", "security.insecureAPI.UncheckedReturn"));
    checkers.add(ClankCheckerBuilder.build("security.insecureAPI.getpw", "security.insecureAPI.getpw"));
    checkers.add(ClankCheckerBuilder.build("security.insecureAPI.gets", "security.insecureAPI.gets"));
    checkers.add(ClankCheckerBuilder.build("security.insecureAPI.mkstemp", "security.insecureAPI.mkstemp"));
    checkers.add(ClankCheckerBuilder.build("security.insecureAPI.mktemp", "security.insecureAPI.mktemp"));
    checkers.add(ClankCheckerBuilder.build("security.insecureAPI.rand", "security.insecureAPI.rand"));
    checkers.add(ClankCheckerBuilder.build("security.insecureAPI.strcpy", "security.insecureAPI.strcpy"));
    checkers.add(ClankCheckerBuilder.build("security.insecureAPI.vfork", "security.insecureAPI.vfork"));
    checkers.add(ClankCheckerBuilder.build("unix", "unix"));
    checkers.add(ClankCheckerBuilder.build("unix.API", "unix.API"));
    checkers.add(ClankCheckerBuilder.build("unix.Malloc", "unix.Malloc"));
    checkers.add(ClankCheckerBuilder.build("unix.MallocSizeof", "unix.MallocSizeof"));
    checkers.add(ClankCheckerBuilder.build("unix.MismatchedDeallocator", "unix.MismatchedDeallocator"));
    checkers.add(ClankCheckerBuilder.build("unix.cstring.BadSizeArg", "unix.cstring.BadSizeArg"));
    checkers.add(ClankCheckerBuilder.build("unix.cstring.NullArg", "unix.cstring.NullArg"));
    checkers.add(ClankCheckerBuilder.build("alpha.core", "alpha.core"));
    checkers.add(ClankCheckerBuilder.build("alpha.cplusplus", "alpha.cplusplus"));
    checkers.add(ClankCheckerBuilder.build("alpha.valist", "alpha.valist"));//comment it as it breaks NullDeref for example
    checkers.add(ClankCheckerBuilder.build("alpha.deadcode", "alpha.deadcode"));
    checkers.add(ClankCheckerBuilder.build("alpha.security", "alpha.security"));
    checkers.add(ClankCheckerBuilder.build("alpha.unix", "alpha.unix"));
    
    
  }

  private CheckerRegistry() {

  }

  public final Collection<ClankChecker> getBuiltInCheckers() {
    return checkers;
  }

  private static class ClankCheckerBuilder {

    static ClankChecker build(String option, String name) {
      String description = Utilitites.getMessage(CheckerRegistry.class, option + ".description");//NOI18N
      String example = Utilitites.getMessage(CheckerRegistry.class, option + ".example");//NOI18N
      String languages = Utilitites.getMessage(CheckerRegistry.class, option + ".lang");//NOI18N
      String[] langs = languages.split(",");
      ArrayList<InputKind> langValues = new ArrayList<>();
      for (String lang : langs) {
        langValues.add(InputKind.valueOf(lang));
      }
      return new ClankCheckerImpl(option, name, description, example, langValues);
    }

  }

  private static class ClankCheckerImpl extends ClankChecker {

    private final String name;
    private final String description;
    private final String example;
    private final ArrayList<InputKind> langs;

    ClankCheckerImpl(String option, String name, String description, String example, Collection<InputKind> langs) {
      super(option);
      this.name = name;
      this.description = description;
      this.example = example;
      this.langs = new ArrayList<>(langs);
    }

    @Override
    public String getName() {
      return name;
    }

    @Override
    public String getDescription() {
      return description;
    }

    @Override
    public String getExample() {
      return example;
    }

    @Override
    public Collection<InputKind> getLanguage() {
      return langs;
    }

  }

  @ServiceProvider(service = ClankCheckerProvider.class, position = 1000)
  public final static class ClankCheckerProviderBuiltIn implements ClankCheckerProvider {

    @Override
    public Collection<ClankChecker> getCheckers() {
      return CheckerRegistry.checkers;
    }

  }

}
